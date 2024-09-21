package org.example.clztoolsconsole.sys.department.web;


import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.sys.department.mapper.SysDepartmentMapper;
import org.example.clztoolsconsole.sys.department.service.SysDepartmentService;
import org.example.clztoolsconsole.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/department")
public class SysDepartmentController extends BaseController<SysDepartmentService, SysDepartmentMapper, SysDepartment> {

    private final SysDepartmentService sysDepartmentService;

    @Autowired
    public SysDepartmentController(SysDepartmentService sysDepartmentService) {
        super(sysDepartmentService);
        this.sysDepartmentService = sysDepartmentService;
    }
}
