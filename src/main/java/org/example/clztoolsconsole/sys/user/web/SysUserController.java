package org.example.clztoolsconsole.sys.user.web;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.sys.user.service.SysUserService;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.example.clztoolsconsole.utils.Page;
import org.example.clztoolsconsole.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public AjaxJson getUserList(@RequestBody SysUser user, HttpServletRequest request, HttpServletResponse response) {
        Page<SysUser> page = new Page<>();
        page.setList(sysUserService.findList(user));
        page.setCount(sysUserService.getCount(user));
        return AjaxJson.success(request,response).put("page", page);
    }

    @PostMapping("/save")
    public AjaxJson save(@RequestBody SysUser user, HttpServletRequest request, HttpServletResponse response) {
        SysUser sysUser = new SysUser();
        sysUser.setId(TokenUtils.getUid(request));
        user.setUpdatedBy(sysUser);
        Map<Boolean, String> save = sysUserService.save(user);
        boolean isSuccess = save.containsKey(true);
        String message = save.get(isSuccess);
        return isSuccess?AjaxJson.success(message,request,response):AjaxJson.error(message,HttpStatus.HTTP_CONFLICT,request,response).put("code", HttpStatus.HTTP_CONFLICT);
    }

    @DeleteMapping("/delete")
    public AjaxJson deleteByIds(String ids, HttpServletRequest request, HttpServletResponse response) {
        sysUserService.delete(ids);
        return AjaxJson.success(request,response);
    }

    @PostMapping("/login")
    public AjaxJson getLogin(@RequestBody SysUser user, HttpServletRequest request, HttpServletResponse response) {
        SysUser sysUser = sysUserService.getToken(user);
        if (sysUser == null) {
            return AjaxJson.error("账号或密码错误",HttpStatus.HTTP_UNAUTHORIZED,request,response);
        }
        return AjaxJson.success("操作成功",request,response).put("sysUser", sysUser);
    }


}
