/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/7
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common.header;

import com.yize.cheesecake.common.IpUtils;
import com.yize.cheesecake.common.encrypt.AesEncryptUtils;
import com.yize.cheesecake.common.exception.AuthorizationFailedException;
import com.yize.cheesecake.common.exception.ExceptionCatch;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * 获取HTTP请求头的资料
 */
@NoArgsConstructor
public class GetHeader {

    /**
     * 取得访客的HTTP会话对象
     */
    private static HttpServletRequest compare() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * 获得设备类型
     *
     * @return 设备类型
     */
    public static String getDeviceType() {
        String result = Optional.of(compare().getHeader("user-agent")).get().toLowerCase();
        if (result.isEmpty()) {
            result = Optional.of(compare().getHeader("useragent")).get().toLowerCase();
        }
        return result;
    }

    /**
     * 获得 ACCESS_TOKEN
     *
     * @return 令牌 Token
     */
    public static String getUserToken() {
        try {
            String token = Optional.ofNullable(compare().getHeader("access_token")).orElseGet(() -> "");
            if (token.length() > 1) {
                token = AesEncryptUtils.decrypt(token);
            }
            return token;
        } catch (Exception e) {
            throw new AuthorizationFailedException(e.getMessage());
        }
    }

    /**
     * 获得设备ID
     *
     * @return 设备 ID编号
     */
    public static String getDeviceId() {
        String deviceId = Optional.ofNullable(compare().getHeader("deviceId")).orElseGet(() -> "");
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
     * @return IP地址
     */
    public static String getIpAddr() {
        return Optional.of(IpUtils.getIpAddr(compare())).get();
    }

}
