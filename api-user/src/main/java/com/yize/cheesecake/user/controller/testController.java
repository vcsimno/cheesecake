/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.yize.cheesecake.user.utils.RedisKeys;
import com.yize.cheesecake.user.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class testController {

    @Resource
    @Qualifier("redis_db1")
    private RedisTemplate<String, String> redisConfig1;

    private testConn conn;

    public testController(testConn conn) {
        this.conn = conn;
    }

    @GetMapping(value = "/login/{type}")
    public String test(@PathVariable("type") String type) {
        RedisUtil redisUtil = new RedisUtil(redisConfig1);
        JSONObject object = JSONObject.parseObject("{\"characters\":\"user\",\"permission\":[\"insert\",\"update\"],\"invalidTime\":\"2022-10-26 14:37:59\",\"account\":\"testAccount\",\"token\":\"zHiWLQiLLaA2uPlA5FtKupOGM\"}");
        redisUtil.set(RedisKeys.USER_ACCESS_TOKEN.getValue() + object.getString("token"), object.toJSONString());
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

    @GetMapping(value = "/main")
    public String test3() {
        return "success.";
    }
}
