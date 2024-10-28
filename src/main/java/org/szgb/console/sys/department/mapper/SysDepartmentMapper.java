package org.szgb.console.sys.department.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {
}
