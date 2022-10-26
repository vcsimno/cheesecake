
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway.filters;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {

    private static final Logger LOGGER = LogManager.getLogger(LogGatewayFilterFactory.class);

    //构造函数
    public LogGatewayFilterFactory() {
        super(Config.class);
    }

    public List<String> shortcutFiledOrder() {
        return Arrays.asList("consoleLog", "cacheLog");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (config.isCacheLog()) {
                //System.out.println("CacheLog 已经开启了。");
            }
            if (config.isConsoleLog()) {
                //System.out.println("consoleLog 已经开启了。");
            }
            return chain.filter(exchange);
        };
    }


    @Data
    @NoArgsConstructor
    public static class Config {
        private boolean consoleLog;
        private boolean cacheLog;
    }
}
