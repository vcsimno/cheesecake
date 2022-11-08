/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.utils.packer;

import com.alibaba.fastjson.JSONObject;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import lombok.NoArgsConstructor;

/**
 * 制作返回给客户端的数据包
 */
@NoArgsConstructor
public class PackerFactory {
    /**
     * 生产数据包
     *
     * @param errCode 1=成功操作  0=失败操作
     * @param errMsg  状态代码
     * @param result  结果
     * @return 数据包
     */
    private static String PackerMade(int errCode, String errMsg, Object result) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errCode", errCode); // 表示操作成功与否 1=成功 0=失败
        jsonObject.put("errMsg", errMsg); // 具体的错误表示将写在这里。
        jsonObject.put("data", result); // 内容
        return jsonObject.toJSONString();
    }

    /**
     * 生产失败提示数据包
     *
     * @param errMsg 错误代码
     * @param result 结果
     * @return 数据包
     */
    public static String SendFailed(String errMsg, Object result) {
        return PackerFactory.PackerMade(0, errMsg, result);
    }

    /**
     * 数据库异常提示
     *
     * @return 数据包
     */
    public static String sqlException(String errMsg) {
        return PackerFactory.SendFailed(errMsg, "");
    }

    /**
     * JSON 数据包解析失败
     */
    public static String JSONException() {
        return PackerFactory.JSONException();
    }

    /**
     * 生产成功提示数据包
     *
     * @param result 结果
     * @return 数据包
     */
    public static String SendSuccess(Object result) {
        return PackerFactory.PackerMade(1, "", result);
    }

    /**
     * 发送一个 角色没有授权使用接口的提示
     *
     * @return 数据包
     */
    public static String SendUnAuthorizedCharacters() {
        return PackerFactory.SendFailed(ExceptionCatch.UnAuthorizedCharacters, "");
    }

    /**
     * 发送一个 权限校验失败的提示
     */
    public static String SendUnAuthorizedPermission() {
        return PackerFactory.SendFailed(ExceptionCatch.UnAuthorizedPermission, "");
    }
}
