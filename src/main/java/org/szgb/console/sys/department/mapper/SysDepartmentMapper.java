package org.szgb.console.sys.department.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {
    List<SysDepartment> findChildren(int parentId);

    SysDepartment getDepartmentTree();
}
