package org.example.clztoolsconsole.sys.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper {
    SysUser getOfLogin(SysUser user);
}
