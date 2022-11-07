
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway.service.impl;

import com.yize.cheesecake.gateway.common.Access_Token;
import com.yize.cheesecake.gateway.common.YiRequest;
import com.yize.cheesecake.gateway.service.YiAuthGateWayService;
import com.yize.cheesecake.gateway.utils.redis.RedisUtils;
import com.yize.cheesecake.gateway.utils.redis.RedisUtilsSu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class YiAuthGateWayServiceImpl implements YiAuthGateWayService {

    /*用户access_token 在redis的指针头*/
    private final static String USER_ACCESS_TOKEN = "user-access-token-";

    private final Map<String, List<String>> gates; // 接口

    public YiAuthGateWayServiceImpl() {
        gates = new HashMap<>();
        InitializingGateWay();
    }

    /**
     * 创建访问接口，设定访问接口
     */
    @Override
    public void InitializingGateWay() {
        //创建自由访问接口
        AddFreeGate("/auth/login");// 用户登录 具体接口为： /user/login/{type}
        //创建需要验证接口
        AddAuthGate("/user/main");
    }

    /**
     * 对访问的接口进行权限鉴定， 如果有提交token，需要对token的时效性和合法性进行校验。
     * 如果校验失败的，返回 HTTP 401 未授权状态。
     *
     * @param request 封装好的请求数据。
     * @return boolean 成功返回true标记。
     * @see YiRequest
     */
    @Override
    public boolean PassGateWay(YiRequest request) {
        String[] paths = request.getPath().split("/");

        if (paths.length == 0) return false; // 没有支持直接访问gateway
        StringBuilder path = new StringBuilder();
        path.append("/");
        path.append(paths[1]); // 访问的微服务

        if (paths[2] != null) {  // 访问的API 接口
            path.append("/");
            path.append(paths[2]);
        }
        AtomicBoolean result = new AtomicBoolean(false);
        //放行免验证接口
        if (gates.get("free") != null) {
            List<String> list = new ArrayList<>(gates.get("free"));
            list.forEach(e -> {
                if (e.equals(path.toString())) {
                    result.set(true);
                }
            });
            if (result.get()) {
                return result.get();
            }
        }
        //检验需要登录接口
        try {
            result.set(CheckingAuthGate(request));
        } catch (Exception e) {
            return false;
        }
        return result.get();
    }

    /**
     * 写入开放的接口
     *
     * @param path 接口地址
     */
    @Override
    public void AddFreeGate(String path) {
        insert("free", path);
    }

    /**
     * 写入需要验证权限的接口
     *
     * @param path 接口地址
     */
    @Override
    public void AddAuthGate(String path) {
        insert("auth", path);
    }

    /**
     * 对会话失效进行校验，如果缓存服务器不存在token标记，则返回401未授权标记。
     *
     * @param request 请求的实体类对象
     * @return 校验成功则返回 true
     */
    @Override
    public boolean CheckingAuthGate(YiRequest request) {
        try {
            RedisUtils redisUtil = RedisUtils.Instance();
            redisUtil.select(RedisUtilsSu.USERDB);
            Access_Token access_token = new Access_Token(request.getObject().toString());
            /*如果访问客户端的设备ID 与令牌的不一致，校验不予通过*/
            if (!access_token.getDeviceId().equals(request.getDeviceId()))
                return false;
            return !redisUtil.getString(USER_ACCESS_TOKEN + access_token.getToken()).isEmpty();
        } catch (Exception e) {
            //数据包有误
            return false;
        }
    }

    /**
     * API 接口 记录集
     *
     * @param method 记录类别 是 免费通行 还是 需要鉴权
     *               <em> 可以参考AddAuthGate() 和  AddFreeGate() </em>
     * @param path   接口地址 格式  <em>微服务/接口</em> 参考：  /user/login  user 表示微服务名  login是对应的接口
     */
    private void insert(String method, String path) {
        try {
            List<String> list = new ArrayList<>();
            if (gates.get(method) != null) {
                list.addAll(gates.get(method));
            }
            list.add(path);
            gates.put(method, list);
        } catch (Exception e) {
            System.out.println("gates 空指针错误。");
        }

    }
}
