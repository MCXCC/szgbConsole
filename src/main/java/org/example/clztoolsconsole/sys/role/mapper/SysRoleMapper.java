package org.example.clztoolsconsole.sys.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.role.entity.SysRole;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
