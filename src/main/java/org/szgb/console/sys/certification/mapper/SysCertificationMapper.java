package org.szgb.console.sys.certification.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.certification.entity.SysCertification;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysCertificationMapper extends BaseMapper<SysCertification> {

}
