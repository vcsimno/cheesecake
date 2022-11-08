/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.from;

import com.alibaba.fastjson.JSONObject;
import com.yize.cheesecake.common.EscapeUtil;
import com.yize.cheesecake.common.header.GetHeader;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * 读取客户端提交过来的JSOn 格式表单
 *
 * @param <T> 表单的实体类<VO>类型
 */
public class From<T> implements Serializable {

    /*表单VO*/
    @Getter
    private T from;

    @SuppressWarnings("unchecked")
    public From(T t) throws IOException {

        try {

            /*读取用户输入流*/
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(GetHeader.getInputStream()));

            StringBuilder responseBuilder = new StringBuilder();

            String inputString;

            while ((inputString = streamReader.readLine()) != null) {

                /* XSS filter */

                inputString = EscapeUtil.clean(inputString);

                responseBuilder.append(inputString);

            }

            if (responseBuilder.length() > 1) {

                /*把读取到的表单映射到VO*/
                from = (T) JSONObject.parseObject(responseBuilder.toString()).toJavaObject(t.getClass());

            }


        } catch (IOException e) {

            throw new IOException(e.getMessage());

        }


    }

}
