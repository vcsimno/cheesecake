/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common;

import com.alibaba.fastjson.JSONArray;
import com.yize.cheesecake.common.authorize.Access_Token;
import com.yize.cheesecake.common.exception.AuthorizationFailedException;
import com.yize.cheesecake.common.header.GetHeader;

/**
 * 读取用户登录基本信息
 */
public class AuthorUtils {

    private static Access_Token compare() throws AuthorizationFailedException {
        return new Access_Token(GetHeader.getUserToken(), true);
    }

    /**
     * 读取访问令牌
     */
    public static String getToken() throws AuthorizationFailedException {
        return compare().getToken();
    }

    /**
     * 读取账号
     */
    public static String getAccount() throws AuthorizationFailedException {
        return compare().getAccount();
    }

    /**
     * 读取用户角色
     */
    public static JSONArray getCharacters() throws AuthorizationFailedException {
        return compare().getCharacters();
    }

    /**
     * 读取用户权限
     */
    public static JSONArray getPermission() throws AuthorizationFailedException {
        return compare().getPermission();
    }

    /**
     * 读取token所属设备ID
     */
    public static String getDeviceId() throws AuthorizationFailedException {
        return compare().getDeviceId();
    }

    /**
     * 读取token过期时间
     */
    public static String getInvalidTime() throws AuthorizationFailedException {
        return compare().getInvalidTime();
    }

}
