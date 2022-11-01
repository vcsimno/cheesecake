/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.header;

import com.yize.cheesecake.common.authorize.AuthorizationFailedException;
import com.yize.cheesecake.common.encrypt.AesEncryptUtils;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Optional;

/**
 * 获取HTTP请求头的资料
 */
@NoArgsConstructor
public class GetHeader {
    /**
     * 获得设备类型
     *
     * @param request HTTP 会话信息
     * @return 设备类型
     */
    public static String getDeviceType(HttpServletRequest request) {
        String result = Optional.of(request.getHeader("user-agent")).get().toLowerCase();
        if (result.isEmpty()) {
            result = Optional.of(request.getHeader("useragent")).get().toLowerCase();
        }
        return result;
    }

    /**
     * 获得 ACCESS_TOKEN
     *
     * @param request request HTTP 会话信息
     * @return 令牌 Token
     */
    public static String getUserToken(HttpServletRequest request) throws Exception {
        try {
            String token = Optional.ofNullable(request.getHeader("token")).orElseGet(() -> "");
            if (token.length() > 1) {
                token = AesEncryptUtils.decrypt(token);
            }
            return token;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获得设备ID
     *
     * @param request request HTTP 会话信息
     * @return 设备 ID编号
     */
    public static String getDeviceId(HttpServletRequest request) {
        String deviceId = Optional.ofNullable(request.getHeader("deviceId")).orElseGet(() -> "");
        try {
            return AesEncryptUtils.decrypt(deviceId);
        } catch (Exception e) {
            new AuthorizationFailedException(ExceptionCatch.BAD_DEVICE_ID);
        }
        return "";
    }

    /**
     * 获得ip地址
     *
     * @param request request HTTP 会话信息
     * @return IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        return Optional.of(getIpAddress(request)).get();
    }


    /**
     * 获取IP地址
     *
     * @param request HTTP 会话状态
     * @return IP 地址
     */
    private static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                assert inet != null;
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }
}
