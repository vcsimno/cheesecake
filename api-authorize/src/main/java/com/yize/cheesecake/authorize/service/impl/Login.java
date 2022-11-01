/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.yize.cheesecake.authorize.mapper.OnlineMapper;
import com.yize.cheesecake.authorize.mapper.PromisesMapper;
import com.yize.cheesecake.authorize.mapper.UserMapper;
import com.yize.cheesecake.authorize.pojo.*;
import com.yize.cheesecake.authorize.service.Authorization;
import com.yize.cheesecake.authorize.utils.redis.RedisUtils;
import com.yize.cheesecake.authorize.utils.redis.RedisUtilsSu;
import com.yize.cheesecake.common.GenericTools;
import com.yize.cheesecake.common.authorize.*;
import com.yize.cheesecake.common.encrypt.AesEncryptUtils;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import com.yize.cheesecake.common.header.GetHeader;
import com.yize.cheesecake.common.mybatis.MyBatisUtils;
import com.yize.cheesecake.common.redis.RedisKeys;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Login implements Authorization {

    @Value("${yize.session.token-keep}")
    private int token_keep; // token的持续有效时间
    @Autowired
    private HttpServletRequest request;

    public AccessInfo doAuthorization(AuthorizeSubject subject) throws SQLException, AuthorizationFailedException {

        Optional<SqlSession> sqlSession = Optional.ofNullable(MyBatisUtils.getSqlSession());
        if (!sqlSession.isPresent()) {
            throw new SQLException();
        }
        try {
            List<User> userList = null;
            /* 邮箱 密码 模式校验 */
            switch (subject.getMode()) {
                case AuthorizeMode.AUTHORIZEBYPWD:
                    userList = this.CurlUserByPwd(subject, sqlSession.get());
                    break;
                /* 手机 验证码 校验模式 */
                case AuthorizeMode.AUTHORIZEBYCODE:
                    userList = this.CurlUserByCode(subject, sqlSession.get());
                    break;
                /* token 复活模式 */
                case AuthorizeMode.AUTHORIZEBYTOKEN:
                    userList = this.CurlUserByToken(subject, sqlSession.get());
                    break;
                /* 不支持的模式 */
                default:
                    throw new AuthorizationFailedException(ExceptionCatch.BAD_METHOD);
            }

            assert userList != null;


            if (userList.size() == 0) {
                throw new AuthorizationFailedException(ExceptionCatch.USER_NODATA);
            }
            if (userList.get(0).getCcBan().equals("0")) {
                //账号被锁定
                throw new AuthorizationFailedException(ExceptionCatch.BANNED);
            }

            /*清理 如果有登录（WSS连接）记录，则清除，俗称踢下线。 （这个主要限制一个账号只有一个登录设备）*/
            this.KillPreToken(subject, sqlSession.get());

            /*读取用户权限*/
            PromisesMapper promisesMapper = sqlSession.get().getMapper(PromisesMapper.class);
            PromisesExample promisesExample = new PromisesExample();
            promisesExample.createCriteria().andCcAccountEqualTo(userList.get(0).getCcAccount());
            List<Promises> promises = promisesMapper.selectByExample(promisesExample);

            JSONArray promise = new JSONArray();
            for (Promises obj : promises) {
                promise.add(obj.getCcPromise());
            }

            /*建立 AccessInfo*/
            /*10位识别码*/
            String token = GenericTools.getRandomString(10);
            Access_Token access_token = new Access_Token(
                    /*识别码*/
                    token,
                    /*账号*/
                    userList.get(0).getCcAccount(),
                    /*角色*/
                    userList.get(0).getCcCharacters(),
                    /*权限*/
                    promise,
                    /* token有效期 */
                    GenericTools.getDateCompare(LocalDateTime.now().plusDays(token_keep)),
                    /* token 与设备ID绑定 */
                    GetHeader.getDeviceId(request)
            );
            /*对access_token进行aes加密*/
            String tokenEncrypt = AesEncryptUtils.encrypt(access_token.toJSONString().toString());
            AccessInfo info = new AccessInfo(tokenEncrypt);

            /*重新写入新的online*/
            OnlineMapper onlineMapper = sqlSession.get().getMapper(OnlineMapper.class);
            Online online = new Online();
            /*用户的账号*/
            online.setCcAccount(userList.get(0).getCcAccount());
            /*用户的手机区号*/
            online.setCcAreacode(userList.get(0).getCcAreacode());
            /*设备ID*/
            online.setCcDeviceid(GetHeader.getDeviceId(request));
            /*邮箱地址*/
            online.setCcMail(userList.get(0).getCcMail());
            /*登录时间*/
            online.setCcTime(GenericTools.getDateCompare(LocalDateTime.now()));
            /*访问令牌*/
            online.setCcToken(token);
            /*ip地址*/
            online.setCcIpaddr(GetHeader.getIpAddr(request));
            /*手机号码*/
            online.setCcPhone(userList.get(0).getCcPhone());

            onlineMapper.insert(online);

            sqlSession.get().commit();

            /*把token写入redis缓存*/
            RedisUtils redis = RedisUtils.Instance();
            redis.select(RedisUtilsSu.USERDB);
            redis.set(RedisKeys.USER_ACCESS_TOKEN.getValue() + token, tokenEncrypt, (3600L * token_keep));
            /*登录完毕*/
            return info;

        } catch (Exception e) {
            throw new AuthorizationFailedException(e.getMessage());
        } finally {
            sqlSession.get().close();
        }
    }


    /**
     * 根据邮箱 密码 进行账号查询
     *
     * @param subject 账号主体信息
     * @return 用户资料
     */
    private List<User> CurlUserByPwd(AuthorizeSubject subject, SqlSession sqlSession) {

        try {
            UserExample example = new UserExample();
            example.createCriteria().andCcMailEqualTo(subject.getSubject())
                    .andCcPwdEqualTo(subject.getPwd()); // 账号密码登录，也就是 邮箱地址 + 密码
            return curl_user(example, sqlSession);
        } catch (Exception e) {
            sqlSession.close();
            throw new AuthorizationFailedException(ExceptionCatch.SYS);
        }
    }

    /**
     * 根据 手机验证码 进行查询
     *
     * @param subject 账号主体信息
     * @return 用户资料
     */
    private List<User> CurlUserByCode(AuthorizeSubject subject, SqlSession sqlSession) {

        try {
            String key = RedisKeys.PHONE_CODE.getValue() + subject.getSubject();
            RedisUtils redisUtils = RedisUtils.Instance();
            /*选择临时数据库*/
            redisUtils.select(RedisUtilsSu.TEMPLATE);
            /*检查验证码是否正确*/
            if (!redisUtils.getString(key).equals(
                    subject.getPwd()
            )) {
                /*手机验证码不正确*/
                throw new AuthorizationFailedException(ExceptionCatch.BAD_CODE);
            }
            /*删除验证码*/
            redisUtils.del(key);
            /*读取用户数据并返回*/
            UserExample example = new UserExample();
            example.createCriteria().andCcPhoneEqualTo(subject.getSubject());
            return curl_user(example, sqlSession);
        } catch (Exception e) {
            sqlSession.close();
            throw new AuthorizationFailedException(e.getMessage());
        }
    }

    /**
     * 根据token 复活
     *
     * @param subject 账号主体信息
     * @return 用户资料
     */
    private List<User> CurlUserByToken(AuthorizeSubject subject, SqlSession sqlSession) {

        Access_Token access_token = new Access_Token(subject.getAccess_token());
        String deviceId = GetHeader.getDeviceId(request);
        if (!access_token.getDeviceId().equals(deviceId)) {
            /*涉嫌盗用token，返回错误的数据*/
            throw new AuthorizationFailedException(ExceptionCatch.BAD_DATA);
        }
        try {
            /*检查online表，尝试复活token*/
            OnlineMapper onlineMapper = sqlSession.getMapper(OnlineMapper.class);
            OnlineExample onlineExample = new OnlineExample();
            onlineExample.createCriteria().andCcAccountEqualTo(access_token.getAccount()).andCcTokenEqualTo(access_token.getToken());
            long result = onlineMapper.countByExample(onlineExample);
            if (result == 0) {
                /*access_token 已经彻底失效了*/
                throw new AuthorizationFailedException(ExceptionCatch.INVALID_ACCESS_TOKEN);
            }
            /*读取用户数据并返回*/
            UserExample example = new UserExample();
            example.createCriteria().andCcAccountEqualTo(access_token.getAccount());
            return curl_user(example, sqlSession);
        } catch (Exception e) {
            sqlSession.close();
            throw new AuthorizationFailedException(e.getMessage());
        }

    }

    /**
     * 读取用户数据
     *
     * @param example    查询条件
     * @param sqlSession 数据源
     */
    private List<User> curl_user(UserExample example, SqlSession sqlSession) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectByExample(example);
    }

    /**
     * 清理 如果有登录（WSS连接）记录，则清除，俗称踢下线。 （这个主要限制一个账号只有一个登录设备）
     *
     * @param subject 账号主体信息
     */
    private void KillPreToken(AuthorizeSubject subject, SqlSession sqlSession) {
        OnlineMapper onlineMapper = sqlSession.getMapper(OnlineMapper.class);
        OnlineExample example = new OnlineExample();
        Access_Token access_token = null;

        switch (subject.getMode()) {
            case AuthorizeMode.AUTHORIZEBYCODE: {
                /*手机验证码模式*/
                example.createCriteria().andCcPhoneEqualTo(subject.getSubject());
            }
            break;
            case AuthorizeMode.AUTHORIZEBYTOKEN: {
                /*token复活模式*/
                try {
                    access_token = new Access_Token(subject.getAccess_token());
                    example.createCriteria().andCcAccountEqualTo(access_token.getAccount());
                } catch (Exception e) {
                    /*access_token 错误*/
                    throw new AuthorizationFailedException(ExceptionCatch.BAD_DATA);
                }
            }
            break;
            default:
                /*默认使用邮箱密码*/
                example.createCriteria().andCcMailEqualTo(subject.getSubject());
        }
        try {
            List<Online> onlines = onlineMapper.selectByExample(example);
            RedisUtils redisUtils = RedisUtils.Instance();
            String key = "";
            for (Online online : onlines) {
                /*先删除普通登录token*/
                redisUtils.select(RedisUtilsSu.USERDB);
                key = RedisKeys.USER_ACCESS_TOKEN.getValue() + online.getCcToken();
                redisUtils.del(key);
                /*删除wss的token，使其断开连接*/
                redisUtils.select(RedisUtilsSu.WEBSOCKET);
                key = RedisKeys.WSS.getValue() + online.getCcToken();
                redisUtils.del(key);
            }
            /*删除online表*/
            onlineMapper.deleteByExample(example);
            sqlSession.commit();
        } catch (Exception e) {
            throw new AuthorizationFailedException(e.getMessage());
        }
    }
}
