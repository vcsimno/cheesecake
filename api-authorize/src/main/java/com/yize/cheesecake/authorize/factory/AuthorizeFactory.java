/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.factory;

import com.yize.cheesecake.authorize.service.impl.Login;
import com.yize.cheesecake.authorize.utils.SpringUtils;
import com.yize.cheesecake.common.authorize.AccessInfo;
import com.yize.cheesecake.common.authorize.AuthorizeSubject;

import java.io.IOException;
import java.sql.SQLException;

/*
  身份校验工厂
 */
public class AuthorizeFactory {

    /**
     * 登录类
     *
     * @return AccessInfo
     */
    public static AccessInfo doLogin() throws SQLException, IOException {
        return SpringUtils.getBean(Login.class).doAuthorization(); // 返回一个 AccessInfo 信息
    }

    /**
     * 校验支付密码
     *
     * @param subject 操作主体
     * @return String 具体参照调用方法介绍
     */
    public static String doCheckPay(AuthorizeSubject subject) throws SQLException {
        return ""; // 校验失败则返回一个失败标记
    }


}
