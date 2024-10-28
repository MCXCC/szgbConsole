package org.szgb.console.sys.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.role.entity.SysRole;
import org.szgb.console.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
