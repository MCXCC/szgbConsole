package org.example.clztoolsconsole.sys.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.user.entity.SysUserCertification;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserCertificationMapper extends BaseMapper<SysUserCertification> {
}
