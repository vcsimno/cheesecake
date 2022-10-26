
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway.filters;

import com.yize.cheesecake.gateway.common.YiRequest;
import com.yize.cheesecake.gateway.service.YiAuthGateWayService;
import com.yize.cheesecake.gateway.utils.AesEncryptUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

//自定义全局过滤器
//要求：必须实现GlobalFilter,Ordered  并且实现里面的两个方法
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {


    private static final Logger LOGGER = LogManager.getLogger(AuthGlobalFilter.class);
    @Autowired
    private YiAuthGateWayService gateWayService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        /*
            这里对接口进行简单的提交参数拦截
            对需要token校验合法性进行判定。
            用户角色判定，交还给服务本身。
            String path=exchange.getRequest().getPath().subPath(1,2).toString();
         */


        if (gateWayService == null) {
            //告诉前端 服务器发生了错误了
            LOGGER.error("YiAuthGateWayService Autowired has failed.");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }
        String path = exchange.getRequest().getURI().getPath();
        String token = Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("access_token")).orElse("");

        Object obj = null;
        try {
            //考虑到有部分模块是放开不需要 access_token的，所以只对有数据的token进行校验
            if (token.length() > 10) {
                obj = AesEncryptUtils.decrypt(token);
            }

            if (!gateWayService.PassGateWay(new YiRequest(path, obj))) {
                //不能通过认证 不予放行
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

        } catch (Exception e) {
            // 提交的token无法进行解密，数据包涉嫌造假
            // 返回一个未授权
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
