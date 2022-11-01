/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.common.utils.packer;

/**
 * 操作状态标识码 (已弃用)
 *
 * @deprecated
 */
public enum StatusCode {
    /*--------通用--------------*/
    BANNED("BANNED"), // 账号被锁定
    LOGIN_BAD_METHOD("LOGIN_BAD_METHOD"),  //登录中 提交了错误的校验方式
    UNKNOWERROR("UNKNOWERROR"), // 不明错误
    USER_NODATA("USER_NODATA"), // 查询不到用户数据
    BAD_DEVICE_ID("BAD_DEVICE_ID"), // 错误的设备ID （与access_token无法配对）
    SQLEXCEPTION("SQLEXCEPTION"); // 数据库异常错误


    StatusCode(String param) {
    }
}
