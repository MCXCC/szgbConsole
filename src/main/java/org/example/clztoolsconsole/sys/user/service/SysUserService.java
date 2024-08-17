package org.example.clztoolsconsole.sys.user.service;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.sys.user.mapper.SysUserMapper;
import org.example.clztoolsconsole.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    public List<SysUser> findList() {
        return sysUserMapper.findList();
    }

    public Page getCount() {
        Page page = new Page();
        page.setCount(sysUserMapper.getCount());
        return page;
    }

    public SysUser getToken(SysUser user) {
        String token = user.getToken();
        if (token != null) {
            byte[] key = "clz11053".getBytes();
            boolean validate = JWT.of(token).setKey(key).validate(0);
            // 验证 token 的有效性
            if (validate) {
                // 已登录，放行
                JWT jwt =JWT.of(token);
                String id=  jwt.getPayload("uid").toString();
                SysUser sysUser1 = new SysUser();
                sysUser1.setId(Integer.parseInt(id));
                SysUser sysUser2 = sysUserMapper.findById(sysUser1);
                sysUser2.setToken(token);
                return sysUser2;
            }

        }
        SysUser sysUser = sysUserMapper.getOfLogin(user);
        if (sysUser == null) {
            return null;
        } else {
            Map<String, Object> map = new HashMap<String, Object>() {
                private static final long serialVersionUID = 1L;

                {
                    put("uid", sysUser.getId());
                    put("expire_time", System.currentTimeMillis() - 100);
                }
            };

            String newToken = JWTUtil.createToken(map, "clz11053".getBytes());

            return new SysUser(newToken);
        }
    }
}
