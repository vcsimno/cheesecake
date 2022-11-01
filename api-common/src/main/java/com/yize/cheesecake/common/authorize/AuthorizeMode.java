/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.authorize;

/**
 * 校验身份的模式
 */
public class AuthorizeMode {
    public static final String AUTHORIZEBYPWD = "PWD"; // 账号密码验证
    public static final String AUTHORIZEBYCODE = "CODE";  // 验证码登录模式
    public static final String AUTHORIZEBYTOKEN = "TOKEN"; // token复活模式
    public static final String AUTHORIZEBYPAY = "PAY"; // 校验支付密码
}
