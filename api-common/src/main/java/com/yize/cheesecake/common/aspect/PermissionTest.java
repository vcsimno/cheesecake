/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.aspect;

import com.alibaba.fastjson.JSONArray;

/**
 * 对权限进行鉴定
 */
public class PermissionTest {
    public static boolean test(String[] require, JSONArray perMission) {
        /*需求的权限*/
        int req_length = require.length;
        /*符合的权限*/
        int accept_length = 0;
        for (String access : require) {
            for (Object permission : perMission) {
                /*判断是否有具体权限*/
                if (permission.toString().equals(access)) {
                    ++accept_length;
                }
            }
        }
        return accept_length == req_length;
    }
}
