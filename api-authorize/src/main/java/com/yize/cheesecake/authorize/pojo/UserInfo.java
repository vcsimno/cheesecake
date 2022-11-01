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

public class UserInfo implements Serializable {
    private String ccAccount;

    private String ccLasttime;

    private String ccFront;

    private String ccNickname;

    private String ccGender;

    private String ccProvince;

    private String ccCity;

    private String ccAddress;

    private String ccBirthday;

    private static final long serialVersionUID = 1L;

    public String getCcAccount() {
        return ccAccount;
    }

    public void setCcAccount(String ccAccount) {
        this.ccAccount = ccAccount == null ? null : ccAccount.trim();
    }

    public String getCcLasttime() {
        return ccLasttime;
    }

    public void setCcLasttime(String ccLasttime) {
        this.ccLasttime = ccLasttime == null ? null : ccLasttime.trim();
    }

    public String getCcFront() {
        return ccFront;
    }

    public void setCcFront(String ccFront) {
        this.ccFront = ccFront == null ? null : ccFront.trim();
    }

    public String getCcNickname() {
        return ccNickname;
    }

    public void setCcNickname(String ccNickname) {
        this.ccNickname = ccNickname == null ? null : ccNickname.trim();
    }

    public String getCcGender() {
        return ccGender;
    }

    public void setCcGender(String ccGender) {
        this.ccGender = ccGender == null ? null : ccGender.trim();
    }

    public String getCcProvince() {
        return ccProvince;
    }

    public void setCcProvince(String ccProvince) {
        this.ccProvince = ccProvince == null ? null : ccProvince.trim();
    }

    public String getCcCity() {
        return ccCity;
    }

    public void setCcCity(String ccCity) {
        this.ccCity = ccCity == null ? null : ccCity.trim();
    }

    public String getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress == null ? null : ccAddress.trim();
    }

    public String getCcBirthday() {
        return ccBirthday;
    }

    public void setCcBirthday(String ccBirthday) {
        this.ccBirthday = ccBirthday == null ? null : ccBirthday.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ccAccount=").append(ccAccount);
        sb.append(", ccLasttime=").append(ccLasttime);
        sb.append(", ccFront=").append(ccFront);
        sb.append(", ccNickname=").append(ccNickname);
        sb.append(", ccGender=").append(ccGender);
        sb.append(", ccProvince=").append(ccProvince);
        sb.append(", ccCity=").append(ccCity);
        sb.append(", ccAddress=").append(ccAddress);
        sb.append(", ccBirthday=").append(ccBirthday);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}