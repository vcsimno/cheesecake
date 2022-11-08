/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.controller;


import com.yize.cheesecake.authorize.service.impl.SendSmsCode;
import com.yize.cheesecake.authorize.utils.SpringUtils;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import com.yize.cheesecake.common.utils.packer.PackerFactory;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    /**
     * 用户自主调用接口 获取短信验证码
     *
     * @param phone 接收号码
     * @return 调用结果
     */
    @GetMapping(value = "/sendSms/{phone}")
    public String SendSms(@PathVariable("phone") String phone) throws Exception {
        if (phone.length() != 11) {
            return PackerFactory.SendFailed(ExceptionCatch.INVALID_PHONE_NUM, "");
        }
        if (!NumberUtils.isParsable(phone)) {
            return PackerFactory.SendFailed(ExceptionCatch.INVALID_PHONE_NUM, "");
        }
        return SpringUtils.getBean(SendSmsCode.class).doSend(phone);
    }

}
