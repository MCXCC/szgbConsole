package org.szgb.console.sys.department.web;


import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.console.sys.department.mapper.SysDepartmentMapper;
import org.szgb.console.sys.department.service.SysDepartmentService;
import org.szgb.console.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/department")
public class SysDepartmentController extends BaseController<SysDepartmentService, SysDepartmentMapper, SysDepartment> {

    @Autowired
    public SysDepartmentController(SysDepartmentService sysDepartmentService) {
        super(sysDepartmentService);
    }
}
