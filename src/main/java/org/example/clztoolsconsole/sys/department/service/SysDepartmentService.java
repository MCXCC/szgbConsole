package org.example.clztoolsconsole.sys.department.service;

import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.sys.department.mapper.SysDepartmentMapper;
import org.example.clztoolsconsole.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDepartmentService {
    @Autowired
    SysDepartmentMapper sysDepartmentMapper;

    public List<SysDepartment> findList() {
        return sysDepartmentMapper.findList();
    }

    public Page getCount() {
        Page page = new Page();
//        page.setCount(sysDepartmentMapper.getCount());
        return page;
    }
}
