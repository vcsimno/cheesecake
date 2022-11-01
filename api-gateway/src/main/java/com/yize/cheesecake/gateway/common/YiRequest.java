
/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */
package com.yize.cheesecake.gateway.common;

import lombok.Getter;

/**
 * 为过滤器传输参数
 *
 * @author yize
 * Date: 2022年10月25日16:32:54
 */
public class YiRequest {

    @Getter
    private final String path;//请求的路径

    @Getter
    private final Object object;//token 数据包

    /*本次访问的deviceID*/
    @Getter
    private final String deviceId;

    public YiRequest(String path, Object object, String deviceId) {
        this.path = path;
        this.object = object;
        this.deviceId = deviceId;
    }
}
