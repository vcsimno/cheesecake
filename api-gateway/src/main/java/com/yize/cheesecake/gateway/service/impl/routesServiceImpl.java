
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway.service.impl;

import com.yize.cheesecake.gateway.service.routesService;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class routesServiceImpl implements routesService {
    @Override
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user_route", r -> r.path("/user/**")
                        .filters(f -> f.rewritePath("/user/(?<segment>.*)", "/${segment}"))
                        .uri("lb://cheesecake-user"))
                .route("api_route", r -> r.path("/api/**")
                        .filters(f -> f.rewritePath("/api/(?<segment>.*)", "/${segment}"))
                        .uri("lb://cheesecake-api"))
                .route("auth_route", r -> r.path("/auth/**")
                        .filters(f -> f.rewritePath("/auth/(?<segment>.*)", "/${segment}"))
                        .uri("lb://cheesecake-auth"))
                .route("wss_route", r -> r.path("/wss/**")
                        .filters(f -> f.rewritePath("/wss/(?<segment>.*)", "/${segment}"))
                        .uri("lb://service-xserver-websocket"))
                .build();

    }
}
