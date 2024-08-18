package org.example.clztoolsconsole.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private static final byte[] key="clz11053".getBytes();

    /**
     * 获取token
     * @param uid id
     * @return token
     */
    public static String getToken(Integer uid) {
        Map<String, Object> map = new HashMap<>() {
            @Serial
            private static final long serialVersionUID = 1L;

            {
                put("uid", uid);
                put("expire_time", System.currentTimeMillis() - 100);
            }
        };

        return JWTUtil.createToken(map, key);
    }

    /**
     * 验证token
     * @param token token
     * @return 布尔值
     */
    public static boolean verifyToken(String token) {
        return JWT.of(token).setKey(key).validate(0);
    }

    /**
     * 获取uid
     * @param token token
     * @return uid
     */
    public static Integer getUid(String token) {
        return Integer.parseInt(JWT.of(token).getPayload("uid").toString());
    }
}
