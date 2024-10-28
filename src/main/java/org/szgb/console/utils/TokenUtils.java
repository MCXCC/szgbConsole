package org.szgb.console.utils;

import cn.hutool.jwt.JWT;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenUtils {
    private static final byte[] key = "clz11053".getBytes();
    private static final Long expireTime = 1000 * 60 * 60 * 24 * 2L;

    /**
     * 获取token
     *
     * @param uid id
     * @return token
     */
    public static String getToken(Integer uid) {

        return JWT.create().setPayload("uid", uid).setPayload("expire_time", System.currentTimeMillis() + expireTime).setKey(key).sign();
    }


    /**
     * 验证token
     * <p>
     * 该方法主要负责验证传入的token是否有效这包括两部分的验证：
     * 1. 使用预设的密钥验证token的签名是否正确
     * 2. 检查token的过期时间是否晚于当前时间，以确保token未过期
     *
     * @param token 待验证的token字符串
     * @return 返回布尔值，表示token是否有效true表示有效，false表示无效
     */
    public static boolean verifyToken(String token) {
        // 验证token的签名并检查token是否已过期
        return (JWT.of(token).setKey(key).verify()) && ((Long.parseLong(JWT.of(token).getPayload("expire_time").toString())) >= (System.currentTimeMillis()));
    }


    /**
     * 获取uid
     *
     * @param token token
     * @return uid
     */
    public static Integer getUid(String token) {
        return Integer.parseInt(JWT.of(token).getPayload("uid").toString());
    }

    public static Integer getUid(HttpServletRequest request) {
        return Integer.parseInt(request.getAttribute("uid").toString());
    }


}
