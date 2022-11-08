/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/8
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.authorize.service;

public interface SmsService {

    /**
     * 发送短信
     *
     * @param sendTo 接收人
     */
    String doSend(String sendTo) throws Exception;
}
