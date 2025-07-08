package org.szgb.console.sys.role.web;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.sys.role.entity.SysRole;
import org.szgb.console.sys.role.mapper.SysRoleMapper;
import org.szgb.console.sys.role.service.SysRoleService;
import org.szgb.console.sys.user.entity.SysUserRole;
import org.szgb.console.sys.user.service.SysUserRoleService;
import org.szgb.core.base.web.BaseController;
import org.szgb.core.utils.AjaxJson;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/sys/role")
public class SysRoleController extends BaseController<SysRoleService, SysRoleMapper, SysRole> {
    private final SysUserRoleService sysUserRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService, SysUserRoleService sysUserRoleService) {
        super(sysRoleService);
        this.sysUserRoleService = sysUserRoleService;
    }

    @Override
    public AjaxJson deleteByIds(String ids, HttpServletRequest request, HttpServletResponse response) {
        for (String s : ids.split(",")) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRole(new SysRole(s));
            List<SysUserRole> list = sysUserRoleService.findList(sysUserRole);
            if (!(list == null || list.isEmpty())) {
                return AjaxJson.error("存在该角色用户", HttpStatus.HTTP_BAD_REQUEST, request, response);
            }
        }
        return super.deleteByIds(ids, request, response);
    }
}
