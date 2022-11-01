/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.controller;

import com.yize.cheesecake.user.config.SocketServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cheesecake-api", fallbackFactory = SocketServiceFallBack.class) // 指定FC调用的微服务名称
public interface testConn {

    @GetMapping(value = "/insert/{msg}")
    String test(@PathVariable("msg") String msg);
}
