/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.utils;

import lombok.Getter;

public enum LimitStringFlag {

    LIMIT_1(1),
    LIMIT_6(6),
    LIMIT_20(20),
    LIMIT_25(25),
    LIMIT_100(100);

    @Getter
    public final int value;

    LimitStringFlag(int len) {
        value = len;
    }
}
