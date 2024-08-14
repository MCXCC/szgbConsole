package org.example.clztoolsconsole.sys.user.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.sys.user.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    public SysUser getToken(SysUser user) {
        SysUser sysUser = sysUserMapper.getOfLogin(user);
        if (sysUser == null) {
            return null;
        } else {
            Map<String, Object> map = new HashMap<String, Object>() {
                private static final long serialVersionUID = 1L;
                {
                    put("uid", sysUser.getId());
                    put("expire_time", System.currentTimeMillis() -100);
                }
            };

            String token = JWTUtil.createToken(map, "clz11053".getBytes());

            return new SysUser(token);
        }
    }
}
