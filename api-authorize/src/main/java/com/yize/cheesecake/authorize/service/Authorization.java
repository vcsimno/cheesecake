/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.service;


import com.yize.cheesecake.common.authorize.AccessInfo;

import java.io.IOException;
import java.sql.SQLException;

public interface Authorization {
    /**
     * 进行身份认证 并返回一个是否成功
     *
     * @return 登录信息 （token）
     */
    AccessInfo doAuthorization() throws SQLException, IOException;
}
