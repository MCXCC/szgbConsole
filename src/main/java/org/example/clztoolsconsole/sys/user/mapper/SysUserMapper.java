package org.example.clztoolsconsole.sys.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser getOfLogin(SysUser user);
}
