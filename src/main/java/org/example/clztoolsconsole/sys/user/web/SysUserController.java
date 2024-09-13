package org.example.clztoolsconsole.sys.user.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.sys.user.service.SysUserService;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/sys/user")
public class SysUserController {

    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PostMapping("/list")
    public AjaxJson getUserList(@RequestBody SysUser user) {
        System.out.println("user = " + user);
        return AjaxJson.success("操作成功").put(sysUserService.findList(user)).page(sysUserService.getCount());
    }

    @PostMapping("/login")
    public AjaxJson getLogin(@RequestBody SysUser user) {
        SysUser sysUser = sysUserService.getToken(user);
        if (sysUser == null) {
            return AjaxJson.error("账号或密码错误");
        }
        return AjaxJson.success("操作成功").put(sysUser);
    }


}
