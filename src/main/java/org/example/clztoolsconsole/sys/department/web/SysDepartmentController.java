package org.example.clztoolsconsole.sys.department.web;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.sys.department.service.SysDepartmentService;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.example.clztoolsconsole.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @return AjaxJson对象，其中包括部门数据
     */
    @PostMapping("/list")
    public AjaxJson getDepartmentList(@RequestBody SysDepartment sysDepartment,HttpServletRequest request, HttpServletResponse response) {
        return AjaxJson.success().put("page",sysDepartmentService.findPage(new Page<>(request,response), sysDepartment));
    }

    @PostMapping("/add")
    public AjaxJson addDepartment(@RequestBody SysDepartment sysDepartment,HttpServletRequest request) {
        SysUser sysUser = new SysUser();
        sysUser.setId(Integer.parseInt( request.getAttribute("uid").toString()));
        sysDepartment.setUpdatedBy(sysUser);
        sysDepartmentService.addDepartment(sysDepartment);
        return AjaxJson.success();
    }
}
