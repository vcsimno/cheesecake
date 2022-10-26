/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.gateway.service;

import com.yize.cheesecake.gateway.common.YiRequest;

/**
 * 访问网关服务
 */
public interface YiAuthGateWayService {
    /**
     * 网关实现类
     *
     * @param request HTTP会话信息
     * @return 是否通过
     * @throws Exception 运行异常
     */
    boolean PassGateWay(YiRequest request) throws Exception;

    /**
     * 对网关系统进行初始化
     */
    void InitializingGateWay();

    /**
     * 录入放行接口
     *
     * @param path 接口地址
     */
    void AddFreeGate(String path);

    /**
     * 录入需要校验接口
     *
     * @param path 接口地址
     */
    void AddAuthGate(String path);

    /**
     * 看哦按擦户访问请求是否通过
     *
     * @param token 会话令牌
     * @return 是否通过
     */
    boolean CheckingAuthGate(String token);
}
