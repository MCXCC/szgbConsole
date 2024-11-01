package org.szgb.console.sys.department.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.console.sys.department.mapper.SysDepartmentMapper;
import org.szgb.core.base.service.BaseService;
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

    @Override
    protected void delete(List<SysDepartment> entityList) {
        for (SysDepartment entity : entityList) {
            SysDepartment sysDepartment = new SysDepartment();
            sysDepartment.setParent(entity);
            List<SysDepartment> list = this.findList(sysDepartment);
            if(!list.isEmpty()){
               this.delete(list);
            }
            mapper.delete(entity);
        }
    }

    @Override
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            int i = Integer.parseInt(s);
            SysDepartment sysDepartment = new SysDepartment();
            sysDepartment.setParent(mapper.get(i));
            List<SysDepartment> list = this.findList(sysDepartment);
            if(!list.isEmpty()){
                this.delete(list);
            }
            mapper.delete(i);
        }
    }
}
