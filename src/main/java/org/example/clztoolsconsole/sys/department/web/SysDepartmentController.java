package org.example.clztoolsconsole.sys.department.web;


import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.sys.department.service.SysDepartmentService;
import org.example.clztoolsconsole.utils.AjaxJson;
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

    @GetMapping("/list")
    public AjaxJson getDepartmentList() {
        return AjaxJson.success("操作成功").put(sysDepartmentService.findList()).page(sysDepartmentService.getCount());
    }

    @PostMapping("/add")
    public AjaxJson addDepartment(@RequestBody SysDepartment sysDepartment) {
        sysDepartmentService.addDepartment(sysDepartment);
        return AjaxJson.success("操作成功");
    }
}
