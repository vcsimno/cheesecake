/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;

    private String ccAccount;

    private String ccPwd;

    private String ccSecret;

    private String ccMail;

    private String ccPhone;

    private String ccAreacode;

    private String ccCreatetime;

    private String ccBan;

    private String ccCharacters;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCcAccount() {
        return ccAccount;
    }

    public void setCcAccount(String ccAccount) {
        this.ccAccount = ccAccount == null ? null : ccAccount.trim();
    }

    public String getCcPwd() {
        return ccPwd;
    }

    public void setCcPwd(String ccPwd) {
        this.ccPwd = ccPwd == null ? null : ccPwd.trim();
    }

    public String getCcSecret() {
        return ccSecret;
    }

    public void setCcSecret(String ccSecret) {
        this.ccSecret = ccSecret == null ? null : ccSecret.trim();
    }

    public String getCcMail() {
        return ccMail;
    }

    public void setCcMail(String ccMail) {
        this.ccMail = ccMail == null ? null : ccMail.trim();
    }

    public String getCcPhone() {
        return ccPhone;
    }

    public void setCcPhone(String ccPhone) {
        this.ccPhone = ccPhone == null ? null : ccPhone.trim();
    }

    public String getCcAreacode() {
        return ccAreacode;
    }

    public void setCcAreacode(String ccAreacode) {
        this.ccAreacode = ccAreacode == null ? null : ccAreacode.trim();
    }

    public String getCcCreatetime() {
        return ccCreatetime;
    }

    public void setCcCreatetime(String ccCreatetime) {
        this.ccCreatetime = ccCreatetime == null ? null : ccCreatetime.trim();
    }

    public String getCcBan() {
        return ccBan;
    }

    public void setCcBan(String ccBan) {
        this.ccBan = ccBan == null ? null : ccBan.trim();
    }

    public String getCcCharacters() {
        return ccCharacters;
    }

    public void setCcCharacters(String ccCharacters) {
        this.ccCharacters = ccCharacters == null ? null : ccCharacters.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ccAccount=").append(ccAccount);
        sb.append(", ccPwd=").append(ccPwd);
        sb.append(", ccSecret=").append(ccSecret);
        sb.append(", ccMail=").append(ccMail);
        sb.append(", ccPhone=").append(ccPhone);
        sb.append(", ccAreacode=").append(ccAreacode);
        sb.append(", ccCreatetime=").append(ccCreatetime);
        sb.append(", ccBan=").append(ccBan);
        sb.append(", ccCharacters=").append(ccCharacters);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}