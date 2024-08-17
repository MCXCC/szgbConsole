package org.example.clztoolsconsole.sys.department.web;


import org.example.clztoolsconsole.sys.department.service.SysDepartmentService;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
