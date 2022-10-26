/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplication {
    private static final Logger LOGGER = LogManager.getLogger(GateWayApplication.class);

    public static void main(String[] args) throws Exception {
        //获取Logger对象的实例
        LOGGER.info("网关服务器启动中-----------------------------------------------------");
        SpringApplication.run(GateWayApplication.class, args);
        LOGGER.info("-----------------------------------------------------");
        LOGGER.info("网关服务器启动成功。");
    }
}
