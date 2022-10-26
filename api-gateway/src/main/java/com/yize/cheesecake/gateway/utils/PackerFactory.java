
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 制作返回给客户端的数据包
 */
@NoArgsConstructor
public class PackerFactory {
    private static final Logger LOGGER = LogManager.getLogger(PackerFactory.class);

    /**
     * 生产数据包
     *
     * @param state      0=成功操作  1=失败操作
     * @param actionCode 动作代码
     * @param statusCode 状态代码
     * @param result     结果
     * @return 数据包
     */
    private static JSONObject packerMade(int state, ActionCode actionCode, StatusCode statusCode, Object result) {
        Map<String, Object> r = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        try {
            r.put("state", state); // 表示操作成功与否 0=成功 1=失败
            r.put("action", actionCode); // 当前的操作
            r.put("result", statusCode); // 操作结果的描述
            r.put("data", result); // 内容
            jsonObject.putAll(r);

        } catch (Exception e) {
            r.put("state", 1); // 表示操作失败
            r.put("action", actionCode); // 当前的操作
            r.put("result", statusCode); // 错误的原因
            r.put("data", "SERVER REPORT ERROR"); // 内容
            jsonObject.putAll(r);
            WriterLog.writerErrorLog(LOGGER, e);
        }
        return jsonObject;
    }


    /**
     * 生产失败提示数据包
     *
     * @param actionCode 动作代码
     * @param statusCode 状态码
     * @param result     结果
     * @return 数据包
     */
    public static JSONObject failedPacker(ActionCode actionCode, StatusCode statusCode, Object result) {
        return PackerFactory.packerMade(1, actionCode, statusCode, result);
    }

    /**
     * 生产成功提示数据包
     *
     * @param actionCode 动作代码
     * @param statusCode 状态码
     * @param result     结果
     * @return 数据包
     */
    public static JSONObject successPacker(ActionCode actionCode, StatusCode statusCode, Object result) {
        return PackerFactory.packerMade(0, actionCode, statusCode, result);
    }

    /**
     * 访问未授权
     *
     * @param actionCode 动作代码
     * @return 数据包
     */
    public static JSONObject accessRefused(ActionCode actionCode) {
        return PackerFactory.packerMade(1, actionCode, StatusCode.ACCESS_REFUSED, "");
    }

    public static JSONObject invalidParam(ActionCode actionCode) {
        return PackerFactory.packerMade(1, actionCode, StatusCode.INVALID_PARAM, "");
    }

}
