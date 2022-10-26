/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.gateway.utils;

import lombok.Getter;

/**
 * redis keys 前缀
 */
public enum RedisKeys {
    USER_ACCESS_TOKEN("user-access-token-"), // 记录用户的token
    WSS("wss-"); // websocket 连接
    @Getter
    private String value;

    RedisKeys(String param) {
        this.value = param;
    }
}
