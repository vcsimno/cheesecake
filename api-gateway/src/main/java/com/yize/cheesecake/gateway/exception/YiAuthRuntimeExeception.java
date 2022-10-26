
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.gateway.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YiAuthRuntimeExeception extends RuntimeException {

    private static final Logger LOGGER = LogManager.getLogger(YiAuthRuntimeExeception.class);

    public YiAuthRuntimeExeception() {
    }

    public YiAuthRuntimeExeception(String message) {
        super(message);
        LOGGER.error(message);
    }

    public YiAuthRuntimeExeception(Throwable cause) {
        super(cause);
        LOGGER.error(cause.getMessage());
    }

    public YiAuthRuntimeExeception(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message);
    }
}
