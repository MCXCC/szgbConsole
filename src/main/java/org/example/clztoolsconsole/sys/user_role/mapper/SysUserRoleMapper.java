package org.example.clztoolsconsole.sys.user_role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.user_role.entity.SysUserRole;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
