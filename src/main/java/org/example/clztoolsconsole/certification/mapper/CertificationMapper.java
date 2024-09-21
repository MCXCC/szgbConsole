package org.example.clztoolsconsole.certification.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.certification.entity.Certification;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CertificationMapper extends BaseMapper<Certification> {

}
