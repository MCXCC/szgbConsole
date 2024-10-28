package org.szgb.console.sys.department.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.console.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {
}
