/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.vo.author;


import com.yize.cheesecake.common.authorize.AuthorizeMode;

import java.io.Serializable;

/**
 * 用户登录表单
 */
public class SubjectVO implements Serializable {

    /**
     * 登录模式
     * 具体参考
     *
     * @see AuthorizeMode
     */
    private String auth_mode;
    private String auth_subject;
    private String auth_pwd;

    public String getAuth_mode() {
        return auth_mode;
    }

    public void setAuth_mode(String auth_mode) {
        this.auth_mode = auth_mode;
    }

    public String getAuth_subject() {
        return auth_subject;
    }

    public void setAuth_subject(String auth_subject) {
        this.auth_subject = auth_subject;
    }

    public String getAuth_pwd() {
        return auth_pwd;
    }

    public void setAuth_pwd(String auth_pwd) {
        this.auth_pwd = auth_pwd;
    }

    @Override
    public String toString() {
        return "SubjectVO{" +
                ", auth_mode='" + auth_mode + '\'' +
                ", auth_subject='" + auth_subject + '\'' +
                ", auth_pwd='" + auth_pwd + '\'' +
                '}';
    }
}
