package org.example.clztoolsconsole.sys.role.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.role.entity.SysRole;
import org.example.clztoolsconsole.sys.role.mapper.SysRoleMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysRoleService extends BaseService<SysRoleMapper, SysRole> {

    @Autowired
    public SysRoleService(SysRoleMapper sysRoleMapper) {
        super(sysRoleMapper);
    }
}
