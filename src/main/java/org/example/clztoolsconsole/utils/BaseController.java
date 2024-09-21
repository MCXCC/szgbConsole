package org.example.clztoolsconsole.utils;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public abstract class BaseController<S extends BaseService<M, T>, M extends BaseMapper<T>, T extends BeanEntity<T>> {
    protected S service;

    @Autowired
    public BaseController(S service) {
        this.service = service;
    }

    @PostMapping("/list")
    public AjaxJson getList(@RequestBody T entity, HttpServletRequest request, HttpServletResponse response) {
        Page<T> page = new Page<>();
        page.setList(service.findList(entity));
        page.setCount(service.getCount(entity));
        return AjaxJson.success(request, response).put("page", page);
    }

    @PostMapping("/save")
    public AjaxJson save(@RequestBody T entity, HttpServletRequest request, HttpServletResponse response) {
        SysUser sysUser = new SysUser();
        sysUser.setId(TokenUtils.getUid(request));
        entity.setUpdatedBy(sysUser);
        Map<Boolean, String> save = service.save(entity);
        boolean isSuccess = save.containsKey(true);
        String message = save.get(isSuccess);
        return isSuccess ? AjaxJson.success(message, request, response) : AjaxJson.error(message, HttpStatus.HTTP_CONFLICT, request, response).put("code", HttpStatus.HTTP_CONFLICT);
    }

    @DeleteMapping("/delete")
    public AjaxJson deleteByIds(String ids, HttpServletRequest request, HttpServletResponse response) {
        service.delete(ids);
        return AjaxJson.success(request, response);
    }
}
