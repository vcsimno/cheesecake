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

public class Promises implements Serializable {
    private Long id;

    private String ccAccount;

    private String ccPromise;

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

    public String getCcPromise() {
        return ccPromise;
    }

    public void setCcPromise(String ccPromise) {
        this.ccPromise = ccPromise == null ? null : ccPromise.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ccAccount=").append(ccAccount);
        sb.append(", ccPromise=").append(ccPromise);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}