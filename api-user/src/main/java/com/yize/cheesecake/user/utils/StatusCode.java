/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.user.utils;

/**
 * 操作状态标识码
 */
public enum StatusCode {
    /*--------通用--------------*/
    /*有改动*/COOL_DOWN("COOL_DOWN"), // 操作冷却中
    SERVER_REPORT_ERROR("SERVER_REPORT_ERROR"), // 服务器运行时出错
    INVALID_CODE_SECURITY_CODE("INVALID_CODE_SECURITY_CODE"), // 验证码错误
    /*有改动*/ACCESS_REFUSED("ACCESS_REFUSED"), //访问被拒绝 / 登录状态失效
    SMS_FAILED_ERROR("SMS_FAILED_ERROR"), // 短信服务失败
    /*有改动*/EMAIL_GET_CODE_FAILED("EMAIL_GET_CODE_FAILED"), // 邮箱验证码发送失败

    INVALID_PARAM("INVALID_PARAM"), // 提交了错误的表单或参数
    SUCCESS("SUCCESS"), // 请求正确/成功

    /*--------通用结束--------------*/

    /*---------认证鉴权 注册------------------*/
    /*有改动*/LOGIN_REFUSED("LOGIN_REFUSED"), // 鉴权失败 - 账号密码错误
    /*有改动*/LOGIN_FAILED_BLACK_HOUSE("LOGIN_FAILED_BLACK_HOUSE"), // 鉴权失败 - 账号封闭
    LOGIN_FAILED_BLOCK("LOGIN_FAILED_BLOCK"), // 鉴权失败 - 账号停用
    LOGIN_FAILED_REMOVEDk("LOGIN_FAILED_REMOVEDk"), // 鉴权失败 - 账号删除
    LOGIN_FAILED_LOCKED("LOGIN_FAILED_LOCKED"), // 鉴权失败 - 失败鉴权次数超出尝试次数
    /*有改动*/SIGNUP_RECORD_ALREADY_EXIST("SIGNUP_RECORD_ALREADY_EXIST"); // 注册失败 - 账号记录存在


    StatusCode(String param) {
    }
}
