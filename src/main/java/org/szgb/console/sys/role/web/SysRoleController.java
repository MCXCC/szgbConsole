package org.szgb.console.sys.role.web;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.role.entity.SysRole;
import org.szgb.console.sys.role.mapper.SysRoleMapper;
import org.szgb.console.sys.role.service.SysRoleService;
import org.szgb.console.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/role")
public class SysRoleController extends BaseController<SysRoleService, SysRoleMapper, SysRole> {

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        super(sysRoleService);
    }
}
