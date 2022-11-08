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
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 验证号控制器 （阿里手机验证码 和 邮箱验证码）
 */
@Service
@NoArgsConstructor
public class VcCodeController extends AliSMS {
    private static final Logger LOGGER = LogManager.getLogger(VcCodeController.class);
    private JavaMailSender javaMailSender; // spring 邮件发送器

    @Value("${yize.verifyCode.keep}")
    private static int keep; // 一条短信验证码有效期多久
    @Value("${yize.verifyCode.cool-down}")
    private static int coolDown; // 接口冷区 X coolDown秒
    @Value("${yize.app-name}")
    private static String appName; // APP应用的名称

    @Value("${spring.mail.username}")
    private static String username;


    public VcCodeController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送一个验证码给用户 (已登录模式，需要获取用户对应绑定的主体，如绑定的邮箱或手机，通常是登录后需要认证身份时调用的。)
     *
     * @param token 访问令牌
     * @param mode  验证码模式：[ alisms = 阿里巴巴sms， email = 邮箱 ] 暂时支持两个模式。
     *              为什么选择这种方式操作呢，因为考虑到有的项目的短信有扩展华，譬如需要香港澳门等等地区的验证码的模式。
     * @return JSON格式的数据封包返回给前端。
     */
    public static String sendCode(String token, String mode) {
        return "";
    }

    /**
     * 发送一个验证码给用户 （非登录状态，无需验证是否登录，需要提交接收验证码的主体，如 手机号 或 邮箱地址）
     * 这个接口的控制层 需要在 gateway 网关设置免登录开放，否则会出现 401 ERROR
     *
     * @param sendTo 接收主体
     * @param mode   验证码模式：[ alisms = 阿里巴巴sms， email = 邮箱 ] 暂时支持两个模式。
     *               为什么选择这种方式操作呢，因为考虑到有的项目的短信有扩展华，譬如需要香港澳门等等地区的验证码的模式。
     * @return
     */
    public static String sendCodeOf(String sendTo, String mode) {
        return "";
    }


    /**
     * 生成一个验证码 然后交给pring email发送器 发送
     *
     * @param email 接收的邮箱地址
     * @return 是否发送成功
     */
    private boolean doSendEmail(String email) {
        try {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 6; ++i) {
                code.append(new Random().nextInt(9) + 1);
            }
            String text = "您本次的验证码为：" + code + " 请于" + (keep / 60) + "分钟内完成认证。";
            RedisUtils redis = RedisUtils.Instance();
            redis.select(RedisUtilsSu.TEMPLATE);
            redis.set((RedisKeys.MAIL_CODE.getValue() + email), code.toString(), (long) keep);
            return sendMail(email, appName + "发来的邮箱验证码，请尽快完成验证。", text);
        } catch (Exception e) {
            LOGGER.error(LOGGER, e);
            return false;
        }
    }

    /**
     * 邮件发送
     *
     * @param toEmail 接收人
     * @param subject 主题
     * @param text    内容
     * @return 是否成功
     */
    private boolean sendMail(String toEmail, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(username);//发送邮箱，也就是你的邮箱，或者可用上面的代码直接获取
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            return true;
        } catch (MailException e) {
            LOGGER.error(LOGGER, e);
            return false;
        }
    }
}
