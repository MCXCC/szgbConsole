package org.szgb.console.sys.user.web;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.console.sys.user.mapper.SysUserMapper;
import org.szgb.console.sys.user.service.SysUserService;
import org.szgb.console.utils.AjaxJson;
import org.szgb.console.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/user")
public class SysUserController extends BaseController<SysUserService, SysUserMapper, SysUser> {

    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        super(sysUserService);
        this.sysUserService = sysUserService;
    }

    @PostMapping("/login")
    public AjaxJson getLogin(@RequestBody SysUser user, HttpServletRequest request, HttpServletResponse response) {
        SysUser sysUser = sysUserService.getToken(user);
        if (sysUser == null) {
            return AjaxJson.error("账号或密码错误", HttpStatus.HTTP_UNAUTHORIZED, request, response);
        }
        return AjaxJson.success("操作成功", request, response).put("sysUser", sysUser);
    }


}
