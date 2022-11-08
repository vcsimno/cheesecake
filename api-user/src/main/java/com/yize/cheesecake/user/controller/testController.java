/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.controller;

import com.yize.cheesecake.common.annotation.RequiresRoles;
import com.yize.cheesecake.common.utils.packer.PackerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class testController {

    private testConn conn;

    @Autowired
    private HttpServletRequest request;

    public testController(testConn conn) {
        this.conn = conn;
    }

    @GetMapping(value = "/login/{type}")
    public String test(@PathVariable("type") String type) {
        return "hello world" + type;
    }

    @GetMapping(value = "/insert")
    public String test2() {
        try {
            String result = conn.test("this is an test");
            return result;
        } catch (Exception e) {
            System.out.println("微服务下线");
            return "";
        }
    }

    //@RequiresRoles(value = {"superadmin"}, method = "characters") // 表示判断角色
    @RequiresRoles(value = {"user:insert", "user:update", "user:delete"})   // 表示判断权限
    @GetMapping(value = "/main")
    public String test3() {

        return PackerFactory.SendSuccess("OK");
    }

    @RequiresRoles(value = {"user:insert", "user:update"})
    @GetMapping(value = "/main2")
    public String test4() {
        return PackerFactory.SendSuccess("OK");
    }
}
