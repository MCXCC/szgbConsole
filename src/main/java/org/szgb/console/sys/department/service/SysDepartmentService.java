package org.szgb.console.sys.department.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.console.sys.department.mapper.SysDepartmentMapper;
import org.szgb.core.base.service.BaseService;

import java.util.List;

@Slf4j
@Service
public class SysDepartmentService extends BaseService<SysDepartmentMapper, SysDepartment> {

    @Autowired
    public SysDepartmentService(SysDepartmentMapper sysDepartmentMapper) {
        super(sysDepartmentMapper);
    }

    @Override
    @Transactional(readOnly = false)
    protected void delete(List<SysDepartment> entityList) {
        for (SysDepartment entity : entityList) {
            List<SysDepartment> list = mapper.findChildren(entity.getId());
            if (!list.isEmpty()) {
                this.delete(list);
            }
            mapper.delete(entity);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            List<SysDepartment> list = mapper.findChildren(s);
            if (!list.isEmpty()) {
                this.delete(list);
            }
            mapper.delete(s);
        }
    }
    
    @Transactional(readOnly = true)
    public SysDepartment getDepartmentTree() {
        return mapper.getDepartmentTree();
    }
}
