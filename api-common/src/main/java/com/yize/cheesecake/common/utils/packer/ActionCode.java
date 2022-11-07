/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.utils.packer;

/**
 * 动作标识码
 *
 * @deprecated
 */
public enum ActionCode {

    /*....通用......*/
    ACTION_REQUEST, // 通讯时发生...xxx

    LOGIN, // 登录 - 登录过程
    LOGIN_BY_OAUTH,  // 登录 - 授权绑定开放社区登录

    RESETPWD, // 修改密码
    SIGNUP,  // 注册 账号
    GET_CODE_BY_PHONE, // 获取验证码 - 手机验证码
    GET_CODE_BY_EMAIL // 获取验证码 - 邮箱验证码
}
