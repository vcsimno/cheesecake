/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class RequestOriginParserDefinition implements RequestOriginParser {

    @Override
    /*
            定义区分来源：本质作用是通过request域获取来源表示
            然后 交给流控应用 位置进行匹配
    * */
    public String parseOrigin(HttpServletRequest request) {
        String serviceName = request.getParameter("serviceName");
        return serviceName;
    }
}
