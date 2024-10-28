package org.szgb.console.certification.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.certification.entity.Certification;
import org.szgb.console.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CertificationMapper extends BaseMapper<Certification> {

}
