package org.example.clztoolsconsole.sys.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysUserMapper {

    List<SysUser> findList();

    SysUser findById(SysUser user);

    SysUser getOfLogin(SysUser user);

    Integer getCount();
}