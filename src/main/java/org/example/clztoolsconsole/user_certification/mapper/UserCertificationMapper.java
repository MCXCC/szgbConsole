package org.example.clztoolsconsole.user_certification.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.user_certification.entity.UserCertification;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserCertificationMapper extends BaseMapper<UserCertification> {
}
