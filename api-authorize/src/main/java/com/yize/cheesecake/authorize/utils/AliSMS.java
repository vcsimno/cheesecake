/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/3
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.utils;

import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20180501.models.SendMessageWithTemplateRequest;
import com.aliyun.dysmsapi20180501.models.SendMessageWithTemplateResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
/*
  阿里云SMS服务
 */
public class AliSMS {

    private static final Logger LOGGER = LogManager.getLogger(AliSMS.class);
    private static final String KeyId = "LTAI5tC1gBRW31KSfJiAd2J7"; //AccessKey ID
    private static final String KeySecret = ""; //AccessKey Secret
    private static final String endpoint = "dysmsapi.aliyuncs.com";

    /**
     * 配置阿里云短信服务
     *
     * @return 返回信息实例
     * @throws Exception 爬出异常
     */
    private static com.aliyun.dysmsapi20180501.Client createDysmsapiClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(KeyId)
                .setAccessKeySecret(KeySecret);
        // 访问的域名
        config.endpoint = endpoint;
        return new com.aliyun.dysmsapi20180501.Client(config);
    }

    /**
     * 短信发送实体
     *
     * @param client          com.aliyun.dysmsapi20180501.Client
     * @param to              接收者
     * @param from            阿里云发送者签名名称
     * @param templateCode    //发送的模板代码
     * @param templateParam   //模版替换内容
     * @param smsUpExtendCode //暂不需要
     * @return 返回发送结果
     * @throws Exception 抛出异常
     */
    private String sendMessageWithTemplate(com.aliyun.dysmsapi20180501.Client client, String to, String from, String templateCode, String templateParam, String smsUpExtendCode) throws Exception {
        SendMessageWithTemplateRequest req = new SendMessageWithTemplateRequest()
                .setTo(to)
                .setFrom(from)
                .setTemplateCode(templateCode)
                .setTemplateParam(templateParam)
                .setSmsUpExtendCode(smsUpExtendCode);
        SendMessageWithTemplateResponse resp = client.sendMessageWithTemplate(req);
        String res = com.aliyun.teautil.Common.toJSONString(com.aliyun.teautil.Common.toMap(resp));
        com.aliyun.teaconsole.Client.log(res);
        return res;
    }

    /**
     * 使用AK&SK初始化账号Client
     *
     * @return Client
     * @throws Exception 抛出异常
     */
    public static com.aliyun.dysmsapi20170525.Client createClient() throws Exception {
        Config config = new Config()
                // AccessKey ID
                .setAccessKeyId(KeyId)
                // AccessKey Secret
                .setAccessKeySecret(KeySecret);
        // 访问的域名
        config.endpoint = endpoint;
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static String sendSMS(String to, String from, String templateCode, String templateParam) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = createClient();
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName(from)
                .setTemplateCode(templateCode)
                .setPhoneNumbers(to)
                .setTemplateParam(templateParam);
        RuntimeOptions runtime = new RuntimeOptions();
        SendSmsResponse res = client.sendSmsWithOptions(sendSmsRequest, runtime);
        return res.getBody().getMessage();
    }

    /**
     * 给用户发送验证短信
     *
     * @param sendTo 接收人
     * @return 发送结果
     */
    public String sendVerify(String sendTo) throws Exception {

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            code.append(new Random().nextInt(9) + 1);
        }

        Map<String, String> smsCode = new HashMap<>();
        smsCode.put("code", code.toString());

        String[] args_ = {
                sendTo, // 接收方号码
                "阿里云短信测试", //签名名称
                "SMS_154950909", //模版Code
                JSON.toJSONString(smsCode), // 模版替换内容
                //第四位缺省
        };
        java.util.List<String> args = java.util.Arrays.asList(args_);


        return sendSMS(args.get(0), args.get(1), args.get(2), args.get(3)) + "," + code;
    }
}
