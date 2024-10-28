package org.szgb.console.sys.user.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.console.sys.user.mapper.SysUserMapper;
import org.szgb.core.base.service.BaseService;
import org.szgb.console.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysUserService extends BaseService<SysUserMapper, SysUser> {
    private final SysUserMapper sysUserMapper;

    @Autowired
    public SysUserService(SysUserMapper sysUserMapper) {
        super(sysUserMapper);
        this.sysUserMapper = sysUserMapper;
    }

    public SysUser getToken(SysUser user) {
        String token = user.getToken();
        if (token != null) {
            // 已登录，放行
            SysUser sysUser = new SysUser();
            sysUser.setId(TokenUtils.getUid(token));
            sysUser = sysUserMapper.get(sysUser);
            sysUser.setToken(token);
            return sysUser;
        }
        SysUser sysUser = sysUserMapper.getOfLogin(user);
        if (sysUser == null) {
            return null;
        } else {
            sysUser.setToken(TokenUtils.getToken((sysUser.getId())));
            return sysUser;
        }
    }
}
