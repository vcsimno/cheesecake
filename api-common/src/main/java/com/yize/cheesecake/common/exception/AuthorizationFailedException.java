/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.exception;

public class AuthorizationFailedException extends RuntimeException {
    public AuthorizationFailedException() {
    }

    public AuthorizationFailedException(String message) {
        super(message);
    }

    public AuthorizationFailedException(Throwable cause) {
        super(cause);
    }

    public AuthorizationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
