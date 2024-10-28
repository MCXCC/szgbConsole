package org.szgb.console.sys.department.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.console.sys.department.mapper.SysDepartmentMapper;
import org.szgb.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysDepartmentService extends BaseService<SysDepartmentMapper, SysDepartment> {

    @Autowired
    public SysDepartmentService(SysDepartmentMapper sysDepartmentMapper) {
        super(sysDepartmentMapper);
    }
}
