/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.utils.redis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedisUtils extends RedisUtilsSu {

    private static final Logger LOGGER = LogManager.getLogger(RedisUtils.class);

    /*每个工具调用过程都要拥有自己的redis数据库指针*/
    public static RedisUtils Instance() {
        return new RedisUtils();
    }


}
