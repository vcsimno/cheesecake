/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.authorize;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;

/**
 * 登录成功后数据打包类
 */
@Data
public class AccessInfo {
    @Getter
    private String access_token;  // 这里是一个 Access_Token 的JSON对象

    public AccessInfo(String access_token) {
        this.access_token = access_token;
    }

    public String toJSONString() {
        JSONObject object = new JSONObject();
        object.put("access_token", access_token);
        return object.toJSONString();
    }
}
