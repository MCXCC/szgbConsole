package org.example.clztoolsconsole.sys.department.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.sys.department.mapper.SysDepartmentMapper;
import org.example.clztoolsconsole.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SysDepartmentService {
    private final SysDepartmentMapper sysDepartmentMapper;
    @Autowired
    public SysDepartmentService(SysDepartmentMapper sysDepartmentMapper) {
        this.sysDepartmentMapper = sysDepartmentMapper;
    }

    public List<SysDepartment> findList(SysDepartment sysDepartment) {
        return sysDepartmentMapper.findList(sysDepartment);
    }

    public Page<SysDepartment> findPage(Page<SysDepartment> page, SysDepartment sysDepartment){
        page.setList(sysDepartmentMapper.findList(sysDepartment));
        page.setCount(sysDepartmentMapper.getCount(sysDepartment));
        return page;
    }

    public void addDepartment(SysDepartment sysDepartment) {
        sysDepartment.setCreatedBy(sysDepartment.getUpdatedBy());
        sysDepartmentMapper.addDepartment(sysDepartment);
    }
}
