package org.example.clztoolsconsole.sys.department.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.sys.department.mapper.SysDepartmentMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.example.clztoolsconsole.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SysDepartmentService extends BaseService<SysDepartmentMapper, SysDepartment> {

    @Autowired
    public SysDepartmentService(SysDepartmentMapper sysDepartmentMapper) {
        super(sysDepartmentMapper);
    }
}
