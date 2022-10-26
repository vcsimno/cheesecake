/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.gateway.service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * 路由器
 */
public interface routesService {
    RouteLocator routes(RouteLocatorBuilder builder);
}
