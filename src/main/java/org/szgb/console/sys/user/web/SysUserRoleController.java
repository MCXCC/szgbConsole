package org.szgb.console.sys.user.web;

import org.szgb.console.sys.user.entity.SysUserRole;
import org.szgb.console.sys.user.mapper.SysUserRoleMapper;
import org.szgb.console.sys.user.service.SysUserRoleService;
import org.szgb.console.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sys/user/role")
public class SysUserRoleController extends BaseController<SysUserRoleService, SysUserRoleMapper, SysUserRole> {

    @Autowired
    public SysUserRoleController(SysUserRoleService sysUserRoleService) {
        super(sysUserRoleService);
    }
}
