package org.example.clztoolsconsole.sys.user_role.service;


import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.user_role.entity.SysUserRole;
import org.example.clztoolsconsole.sys.user_role.mapper.SysUserRoleMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysUserRoleService extends BaseService<SysUserRoleMapper, SysUserRole> {
    private final SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    public SysUserRoleService(SysUserRoleMapper sysUserRoleMapper) {
        super(sysUserRoleMapper);
        this.sysUserRoleMapper = sysUserRoleMapper;
    }
}
