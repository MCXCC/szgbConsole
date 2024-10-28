package org.szgb.console.certification.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.certification.entity.Certification;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CertificationMapper extends BaseMapper<Certification> {

}
