/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.exception;

public class ExceptionCatch {
    /*系统运行时间发送了一个错误。*/
    public static final String SYS = "SYSTEM-RUNTIME-ERROR";
    /*错误的登录提交方法*/
    public static final String BAD_METHOD = "BAD-METHOD";
    /*没有查询到数据*/
    public static final String USER_NODATA = "USER_NODATA";
    /*账号被锁定*/
    public static final String BANNED = "BANNED";
    /*手机验证码不正确*/
    public static final String BAD_CODE = "BAD-CODE";
    /*错误的提交数据*/
    public static final String BAD_DATA = "BAD-DATA";
    /*错误的deviceId*/
    public static final String BAD_DEVICE_ID = "BAD-DEVICE-ID";

    /*用户角色异常*/
    public static final String BAD_CHARACTERS = "BAD_CHARACTERS";
    /*INVALID access_token   登录令牌已经失效或者不存在 */
    public static final String INVALID_ACCESS_TOKEN = "INVALID_ACCESS_TOKEN";

    /*用户角色未授权使用接口*/
    public static final String UnAuthorizedCharacters = "UnAuthorizedCharacters";

    /*用户未授权使用该接口*/
    public static final String UnAuthorizedPermission = "UnAuthorizedPermission";

    /*jsonObject 错误*/
    public static final String BAD_JSON = "BAD-PARAM-DATA";
}
