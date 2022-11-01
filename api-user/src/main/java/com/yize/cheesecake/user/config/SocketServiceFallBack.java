/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * 熔断工厂
 */
@Service
public class SocketServiceFallBack implements FallbackFactory {
    private static final Logger LOGGER = LogManager.getLogger(SocketServiceFallBack.class);

    @Override
    public Object create(Throwable cause) {
        LOGGER.error("微服务调用出错:" + cause.getMessage());
        return null;
    }
}
