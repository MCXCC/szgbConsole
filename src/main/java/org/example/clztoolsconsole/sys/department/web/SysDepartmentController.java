package org.example.clztoolsconsole.sys.department.web;


import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.sys.department.service.SysDepartmentService;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.example.clztoolsconsole.utils.Page;
import org.example.clztoolsconsole.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/sys/department")
public class SysDepartmentController {

    private final SysDepartmentService sysDepartmentService;

    @Autowired
    public SysDepartmentController(SysDepartmentService sysDepartmentService) {
        this.sysDepartmentService = sysDepartmentService;
    }

    /**
     * 获取部门列表信息
     *
     * @return AjaxJson对象，其中包括部门数据
     */
    @PostMapping("/list")
    public AjaxJson getDepartmentList(@RequestBody SysDepartment sysDepartment, HttpServletRequest request,
                                      HttpServletResponse response) {
        Page<SysDepartment> page = new Page<>();
        page.setList(sysDepartmentService.findList(sysDepartment));
        page.setCount(sysDepartmentService.getCount(sysDepartment));
        return AjaxJson.success(request, response).put("page", page);

    }

    @PostMapping("/save")
    public AjaxJson save(@RequestBody SysDepartment sysDepartment, HttpServletRequest request, HttpServletResponse response) {
        SysUser sysUser = new SysUser();
        sysUser.setId(TokenUtils.getUid(request));
        sysDepartment.setUpdatedBy(sysUser);
        Map<Boolean, String> save = sysDepartmentService.save(sysDepartment);
        boolean isSuccess = save.containsKey(true);
        String message = save.get(isSuccess);
        return isSuccess ? AjaxJson.success(message, request, response) : AjaxJson.error(message, HttpStatus.HTTP_CONFLICT, request, response).put("code", HttpStatus.HTTP_CONFLICT);
    }

    @DeleteMapping("/delete")
    public AjaxJson deleteByIds(String ids, HttpServletRequest request, HttpServletResponse response) {
        sysDepartmentService.delete(ids);
        return AjaxJson.success(request, response);
    }
}
