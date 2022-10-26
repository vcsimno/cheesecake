
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway.controller;


import com.yize.cheesecake.gateway.exception.YiAuthRuntimeExeception;
import com.yize.cheesecake.gateway.utils.ActionCode;
import com.yize.cheesecake.gateway.utils.PackerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕捉自定义错误类 YiAuthRuntimeExeception 抛出的异常，并且返回一个JSON给前端。
 *
 * @see YiAuthRuntimeExeception
 */
@ControllerAdvice
public class PermissonException {
    @ExceptionHandler(value = YiAuthRuntimeExeception.class)
    @ResponseBody
    public String YiAuthRuntimeExeception(YiAuthRuntimeExeception e) {
        return PackerFactory.invalidParam(ActionCode.ACCESS_SERVICE).toJSONString();
    }

}
