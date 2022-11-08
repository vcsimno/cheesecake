/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.service.impl;

import com.yize.cheesecake.authorize.service.SmsService;
import com.yize.cheesecake.authorize.utils.redis.RedisUtils;
import com.yize.cheesecake.authorize.utils.redis.RedisUtilsSu;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import com.yize.cheesecake.common.header.GetHeader;
import com.yize.cheesecake.common.redis.RedisKeys;
import com.yize.cheesecake.common.sms.AliSMS;
import com.yize.cheesecake.common.utils.packer.PackerFactory;
import com.yize.cheesecake.common.vo.SmsVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 发送短信验证码
 */
@Service
public class SendSmsCode implements SmsService {
    @Value("${yize.verifyCode.expire}")
    private int smsExpire;  /*短信验证码有效秒*/

    @Value("${yize.verifyCode.cd}")
    private int smsCd; /*短信发送接口冷却时间*/

    @Override
    public String doSend(String sendTo) throws Exception {
        RedisUtils redisUtils = RedisUtils.Instance();
        /*切换到临时库*/
        redisUtils.select(RedisUtilsSu.TEMPLATE);

        String KEY = RedisKeys.SMSCD.getValue() + sendTo + GetHeader.getIpAddr();

        String CD_KEY = redisUtils.getString(KEY);
        if (!CD_KEY.isEmpty()) {
            /*CD中*/
            return PackerFactory.SendFailed(ExceptionCatch.SMS_IS_CD, "");
        }

        /*写入CD标记*/
        redisUtils.set(KEY, GetHeader.getDeviceId(), smsCd);

        /*开始发送 测试用 模拟123456做验证码*/
        SmsVO vo = AliSMS.sendVerify(sendTo, "123456");

        /*写入缓存*/
        redisUtils.set(RedisKeys.PHONE_CODE.getValue() + sendTo, vo.getCode(), smsExpire);

        /*把成功接收验证码手机返回*/
        return PackerFactory.SendSuccess(sendTo);
    }
}
