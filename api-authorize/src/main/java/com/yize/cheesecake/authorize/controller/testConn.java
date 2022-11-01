/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.controller;


import com.yize.cheesecake.authorize.factory.AuthorizeFactory;
import com.yize.cheesecake.common.authorize.AccessInfo;
import com.yize.cheesecake.common.authorize.AuthorizeMode;
import com.yize.cheesecake.common.authorize.AuthorizeSubject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class testConn {

    @Value("${yize.account.salt}")
    private static String salt;

    @GetMapping(value = "/")
    public String test1() throws SQLException {

        /*AuthorizeSubject subject = new AuthorizeSubject(
                AuthorizeMode.AUTHORIZEBYPWD,
                "vcsimno@163.com",
                "123456",
                "MD5",
                salt
        );

         */

        /*

        AuthorizeSubject subject = new AuthorizeSubject(
                AuthorizeMode.AUTHORIZEBYCODE,
                "13632808204",
                "123456",
                "", // 验证码模式不需要加密
                salt
        );

*/
        String token = "1JWKLRbBeJaAFceMRbXc5hyrg0aE6WKY_OGxZk51s6e1j_F5yiXhRsYcySX3MP9yw2p_ujvdSWeNOR1Y77tBYzs0w_m46Ho34YOxI81idwTsyTnSN0L4tEftTM7sgLUWXaeMJHyZ64aL2bbJDtUsawlA92vgsiFQAcrfQp3QIEGjkGJzv+CRl1CHHLs9d2ilA";
        AuthorizeSubject subject = new AuthorizeSubject(
                AuthorizeMode.AUTHORIZEBYTOKEN,
                token);

        AccessInfo info = AuthorizeFactory.doLogin(subject);
        if (info == null) {
            return "对象是null，表示登录失败。";
        }
        return info.toJSONString();
    }
}
