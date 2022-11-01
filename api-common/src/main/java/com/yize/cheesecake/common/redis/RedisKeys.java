/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.redis;

import lombok.Getter;

/**
 * redis keys 前缀
 */
public enum RedisKeys {
    USER_ACCESS_TOKEN("user-access-token-"), // 记录用户的token
    MAIL_CODE("mail-code-"), // 用户邮箱验证码
    PHONE_CODE("phone-code-"), // 用户手机验证码
    WSS("wss-"); // websocket 连接

    @Getter
    private String value;

    RedisKeys(String param) {
        this.value = param;
    }
}
