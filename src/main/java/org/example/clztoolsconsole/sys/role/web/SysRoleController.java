package org.example.clztoolsconsole.sys.role.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.role.entity.SysRole;
import org.example.clztoolsconsole.sys.role.mapper.SysRoleMapper;
import org.example.clztoolsconsole.sys.role.service.SysRoleService;
import org.example.clztoolsconsole.utils.BaseController;
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
