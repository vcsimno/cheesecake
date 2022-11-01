/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.authorize;

import lombok.Data;
import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;

@Data
public class AuthorizeSubject {
    @Getter
    private final String mode; // 表示本次验证提交方式
    @Getter
    private String subject; // 账号
    @Getter
    private String pwd; // 需要进行验证的密码 {验证码模式下代表验证码，账号密码 或支付密码验证时 为对应密码；}
    @Getter
    private String access_token; // 访问令牌 {在验证支付密码/token复活模式时需要传递}
    @Getter
    private String encryptType; // 加密方式
    @Getter
    private String salt; // 加密盐

    /**
     * 用于账号密码登录方式
     */
    public AuthorizeSubject(String mode,
                            String subject,
                            String pwd,
                            String encryptType,
                            String salt
    ) {
        this.mode = mode;
        this.subject = subject;
        if (encryptType.equals("MD5")) {
            this.pwd = DigestUtils.md5Hex(pwd + salt);
        } else {
            this.pwd = pwd;
        }
        this.encryptType = encryptType;
        this.salt = salt;
    }

    /**
     * 用于 验证码模式下使用，验证码验证身份模式下，无需其他参数
     */
    public AuthorizeSubject(String mode,
                            String subject,
                            String pwd) {
        this.mode = mode;
        this.subject = subject;
        this.pwd = pwd;
    }

    /**
     * 用于token复活登录模式
     */
    public AuthorizeSubject(String mode,
                            String access_token) {
        this.mode = mode;
        this.access_token = access_token;
    }
}
