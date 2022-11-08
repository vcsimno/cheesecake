/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class SmsVO implements Serializable {

    @Getter
    @Setter
    /*阿里SMS回调参数*/
    private String Result;
    @Setter
    @Getter
    /*短信验证码*/
    private String code;
}
