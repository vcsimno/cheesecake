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

public class Online implements Serializable {
    private Long id;

    private String ccAccount;

    private String ccToken;

    private String ccMail;

    private String ccPhone;

    private String ccAreacode;

    private String ccTime;

    private String ccIpaddr;

    private String ccDeviceid;

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

    public String getCcToken() {
        return ccToken;
    }

    public void setCcToken(String ccToken) {
        this.ccToken = ccToken == null ? null : ccToken.trim();
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

    public String getCcTime() {
        return ccTime;
    }

    public void setCcTime(String ccTime) {
        this.ccTime = ccTime == null ? null : ccTime.trim();
    }

    public String getCcIpaddr() {
        return ccIpaddr;
    }

    public void setCcIpaddr(String ccIpaddr) {
        this.ccIpaddr = ccIpaddr == null ? null : ccIpaddr.trim();
    }

    public String getCcDeviceid() {
        return ccDeviceid;
    }

    public void setCcDeviceid(String ccDeviceid) {
        this.ccDeviceid = ccDeviceid == null ? null : ccDeviceid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ccAccount=").append(ccAccount);
        sb.append(", ccToken=").append(ccToken);
        sb.append(", ccMail=").append(ccMail);
        sb.append(", ccPhone=").append(ccPhone);
        sb.append(", ccAreacode=").append(ccAreacode);
        sb.append(", ccTime=").append(ccTime);
        sb.append(", ccIpaddr=").append(ccIpaddr);
        sb.append(", ccDeviceid=").append(ccDeviceid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}