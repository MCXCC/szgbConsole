package org.szgb.console.sys.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.user.entity.SysUserCertification;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserCertificationMapper extends BaseMapper<SysUserCertification> {
}
