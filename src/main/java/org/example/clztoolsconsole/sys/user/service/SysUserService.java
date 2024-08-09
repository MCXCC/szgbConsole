package org.example.clztoolsconsole.sys.user.service;

import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.sys.user.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    public SysUser getToken(SysUser user) {
        SysUser sysUser = sysUserMapper.getOfLogin(user);
        if (sysUser == null) {
            return null;
        } else {
            String token = "666";
            return new SysUser(token);
        }
    }
}
