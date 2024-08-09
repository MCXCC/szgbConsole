package org.example.clztoolsconsole.sys.user.web;

import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.sys.user.service.SysUserService;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sys/user")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @PostMapping("/login")
    public AjaxJson getLogin(SysUser user) {
        SysUser sysUser = sysUserService.getToken(user);
        if (sysUser == null) {
            return AjaxJson.error("账号或密码错误");
        }
        return AjaxJson.success("操作成功").put(sysUser);
    }
}
