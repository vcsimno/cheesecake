/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.exception;

import com.alibaba.fastjson2.JSONException;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import com.yize.cheesecake.common.utils.packer.PackerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class AuthorizationFailedExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(AuthorizationFailedExceptionHandler.class);

    @ExceptionHandler(value = AuthorizationFailedException.class)
    @ResponseBody
    public String AuthorizationFailedException(RuntimeException e) {

        String result;
        switch (e.getMessage()) {
            case ExceptionCatch.BANNED:
            case ExceptionCatch.BAD_METHOD:
            case ExceptionCatch.USER_NODATA:
            case ExceptionCatch.BAD_DEVICE_ID:
            case ExceptionCatch.INVALID_ACCESS_TOKEN:
            case ExceptionCatch.BAD_DATA:
            case ExceptionCatch.BAD_CODE: {
                result = PackerFactory.SendFailed(e.getMessage(), "").toJSONString();
            }
            break;
            default: {
                /*未知错误才写入错误日志*/
                LOGGER.error(e.getMessage());
                result = PackerFactory.SendFailed(e.getMessage(), "").toJSONString();
            }
        }
        return result;
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public String SqlException(SQLException e) {
        LOGGER.error(e.getMessage());
        return PackerFactory.sqlException(e.getMessage()).toJSONString(); // 给前端反馈一个错误信息。
    }

    @ExceptionHandler(value = JSONException.class)
    @ResponseBody
    public String JSONException() {
        return PackerFactory.SendFailed(ExceptionCatch.BAD_JSON, "").toJSONString();
    }
}
