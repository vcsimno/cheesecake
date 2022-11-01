/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.user.utils;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 记录日志
 */
@Component
@NoArgsConstructor
public class WriterLog {

    /**
     * 写入系统错误日志
     *
     * @param LOGGER  错误Class的LOGGER实例
     * @param message 具体错误日志
     */
    public static void writerErrorLog(Logger LOGGER, Throwable message) {
        List<String> error = new ArrayList<>();
        error.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        error.add(message.getMessage());

        for (StackTraceElement elem : message.getStackTrace()) {
            error.add(elem.toString());
        }
        error.forEach(LOGGER::error);
    }

}
