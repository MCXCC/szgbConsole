package org.szgb.console.sys.department.web;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.console.sys.department.mapper.SysDepartmentMapper;
import org.szgb.console.sys.department.service.SysDepartmentService;
import org.szgb.core.base.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.core.utils.AjaxJson;

@Slf4j
@RestController
@RequestMapping(value = "/sys/department")
public class SysDepartmentController extends BaseController<SysDepartmentService, SysDepartmentMapper, SysDepartment> {

    @Autowired
    public SysDepartmentController(SysDepartmentService sysDepartmentService) {
        super(sysDepartmentService);
    }

    @GetMapping("/getDepartmentTree")
    public AjaxJson getDepartmentTree(HttpServletRequest request, HttpServletResponse response) {
        return AjaxJson.success(request, response).put("data", service.getDepartmentTree());
    }
}
