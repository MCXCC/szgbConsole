package org.szgb.console.sys.user.service;


import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.user.entity.SysUserRole;
import org.szgb.console.sys.user.mapper.SysUserRoleMapper;
import org.szgb.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysUserRoleService extends BaseService<SysUserRoleMapper, SysUserRole> {

    @Autowired
    public SysUserRoleService(SysUserRoleMapper sysUserRoleMapper) {
        super(sysUserRoleMapper);
    }
}
