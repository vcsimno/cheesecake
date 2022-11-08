/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.utils;

import com.yize.cheesecake.authorize.utils.redis.RedisUtils;
import com.yize.cheesecake.authorize.utils.redis.RedisUtilsSu;
import com.yize.cheesecake.common.redis.RedisKeys;
import com.yize.cheesecake.common.sms.AliSMS;
import com.yize.cheesecake.common.vo.SmsVO;

/**
 * SMS短信管理工具
 */
public class SmsUtils {

    /**
     * 发送阿里SMS短信
     *
     * @param SendTo 接收人
     * @return 发送情况
     */
    public static SmsVO SendAliSms(String SendTo) throws Exception {
        SmsVO smsVO = AliSMS.sendVerify(SendTo, MakeCode());
        /*写入Redis*/
        RedisUtils redisUtils = RedisUtils.Instance();
        redisUtils.select(RedisUtilsSu.TEMPLATE);
        redisUtils.set(RedisKeys.PHONE_CODE.getValue() + SendTo, smsVO.getCode());
        return smsVO;
    }

    private static String MakeCode() {

        StringBuilder code = new StringBuilder();
        code.append(123456); /*模拟环境，用123456代替*/
        /*
        for(int i=0; i<6; ++i){
            code.append(new Random().nextInt(9) + 1);
        }
         */
        return code.toString();
    }
}
