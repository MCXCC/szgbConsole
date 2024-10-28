package org.szgb.console.sys.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser getOfLogin(SysUser user);
}
