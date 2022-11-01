/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user;

import com.yize.cheesecake.user.utils.PropertiesReaderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@PropertySource(value = "classpath:application.yml", encoding = "UTF-8", factory = PropertiesReaderFactory.class)
public class UserApplication {
    private static final Logger LOGGER = LogManager.getLogger(UserApplication.class);

    public static void main(String[] args) {
        //获取Logger对象的实例
        LOGGER.info("用户服务器启动中-----------------------------------------------------");
        SpringApplication.run(UserApplication.class, args);
        LOGGER.info("-----------------------------------------------------");
        LOGGER.info("用户服务器启动成功。");
    }
}
