
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.authorize;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yize.cheesecake.common.encrypt.AesEncryptUtils;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import lombok.Data;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 访问token handler
 */
@Data
public class Access_Token {

    private static final Logger LOGGER = LogManager.getLogger(Access_Token.class);
    @Getter
    private String token; // 25位令牌
    @Getter
    private String account; // 所属账号
    @Getter
    private String characters; // 所属用户组(考虑到系统是购物平台，角色固定则以) 【boss,staff,user,su,suAdmin】 boss=店长; staff=店员;user=用户;su=平台老总;suAdmin平台管理员
    @Getter
    private JSONArray permission; // 权限
    /*token所属的deviceId*/
    private String deviceId;
    @Getter
    private String invalidTime; // token过期时间

    public Access_Token() {
    }

    /**
     * 写入数据，为组合成 JSON数据格式做准备，写入到redis实用还是json格式的。
     *
     * @param token       25位令牌
     * @param account     所属账号
     * @param characters  所属用户组(考虑到系统是购物平台，角色固定则以) 【boss,staff,user,su,suAdmin】 boss=店长; staff=店员;user=用户;su=平台老总;suAdmin平台管理员
     * @param permission  权限
     * @param invalidTime token过期时间
     * @param deviceId    设备ID
     */
    public Access_Token(String token, String account, String characters, JSONArray permission, String invalidTime, String deviceId) {
        this.token = token;
        this.account = account;
        this.characters = characters;
        this.permission = permission;
        this.invalidTime = invalidTime;
        this.deviceId = deviceId;
    }

    /**
     * 把redis读取到的JSON格式字符串，转换回来成pojo
     *
     * @param token 读取到的token数据
     */
    public Access_Token(String token) {
        try {
            JSONObject object = JSONObject.parseObject(AesEncryptUtils.decrypt(token));
            this.token = object.getString("token");
            this.account = object.getString("account");
            this.characters = object.getString("characters");
            this.permission = JSONArray.parseArray(object.getString("permission"));
            this.invalidTime = object.getString("invalidTime");
            this.deviceId = object.getString("deviceId");
        } catch (Exception e) {
            /*错误的数据，无法解密*/
            throw new AuthorizationFailedException(ExceptionCatch.BAD_DATA);
        }
    }

    /**
     * 把对象转换成json数据，用于写入到redis
     *
     * @return 转换后的数据
     */
    public JSONObject toJSONString() {
        JSONObject object = new JSONObject();
        object.put("token", token);
        object.put("account", account);
        object.put("characters", characters);
        object.put("permission", permission);
        object.put("invalidTime", invalidTime);
        object.put("deviceId", deviceId);
        return object;
    }
}
