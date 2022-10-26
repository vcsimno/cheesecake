/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway.utils;

/**
 * 操作状态标识码
 */
public enum StatusCode {
    /*--------通用--------------*/

    SERVER_REPORT_ERROR("SERVER_REPORT_ERROR"), // 服务器运行时出错
    ACCESS_REFUSED("ACCESS_REFUSED"), //访问被拒绝 / 登录状态失效
    INVALID_PARAM("INVALID_PARAM"), // 提交了错误的表单或参数
    SUCCESS("SUCCESS"); // 请求正确/成功


    StatusCode(String param) {
    }
}
