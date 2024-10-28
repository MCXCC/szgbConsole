package org.szgb.console.sys.user.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.console.sys.user.mapper.SysUserMapper;
import org.szgb.core.base.service.BaseService;
import org.szgb.console.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysUserService extends BaseService<SysUserMapper, SysUser> {

    @Autowired
    public SysUserService(SysUserMapper sysUserMapper) {
        super(sysUserMapper);
    }

    public SysUser getToken(SysUser user) {
        String token = user.getToken();
        if (token != null) {
            // 已登录，放行
            SysUser sysUser = new SysUser();
            sysUser.setId(TokenUtil.getUid(token));
            sysUser = this.get(sysUser);
            sysUser.setToken(token);
            return sysUser;
        }
        SysUser sysUser = mapper.getOfLogin(user);
        if (sysUser == null) {
            return null;
        } else {
            sysUser.setToken(TokenUtil.getToken((sysUser.getId())));
            return sysUser;
        }
    }
}
