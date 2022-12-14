/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读取JSON格式的表单
 */
public class RequestJsonFrom {

    private static final Logger LOGGER = LogManager.getLogger(RequestJsonFrom.class);

    /**
     * 读取表单
     *
     * @param request HTTP会话头
     * @return JSONObject 格式的表单数据
     */
    public static JSONObject req(HttpServletRequest request) {
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String inputString;
            while ((inputString = streamReader.readLine()) != null) {
                responseBuilder.append(inputString);
            }
            if (responseBuilder.length() > 1) {
                return JSONObject.parseObject(responseBuilder.toString());
            }
            return new JSONObject();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return new JSONObject();
        }
    }

}
