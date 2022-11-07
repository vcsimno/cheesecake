/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.from;

import com.alibaba.fastjson.JSONObject;
import com.yize.cheesecake.common.EscapeUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读取JSON格式的表单
 */
public class RequestJsonFrom {
    /**
     * 读取表单
     *
     * @param request HTTP会话头
     * @return JSONObject 格式的表单数据
     */
    public static JSONObject ToFrom(HttpServletRequest request) {
        try {

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream()));

            StringBuilder responseBuilder = new StringBuilder();

            String inputString;

            while ((inputString = streamReader.readLine()) != null) {

                /* XSS filter */

                inputString = EscapeUtil.clean(inputString);

                responseBuilder.append(inputString);

            }

            if (responseBuilder.length() > 1) {

                return JSONObject.parseObject(responseBuilder.toString());

            }

            return new JSONObject();

        } catch (IOException e) {

            //WriterLog.writerErrorLog(LOGGER, e);

            return new JSONObject();

        }

    }

}
