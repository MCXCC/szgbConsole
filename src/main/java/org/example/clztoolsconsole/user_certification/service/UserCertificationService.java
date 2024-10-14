package org.example.clztoolsconsole.user_certification.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.user_certification.entity.UserCertification;
import org.example.clztoolsconsole.user_certification.mapper.UserCertificationMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCertificationService extends BaseService<UserCertificationMapper, UserCertification> {

    @Autowired
    public UserCertificationService(UserCertificationMapper userCertificationMapper) {
        super(userCertificationMapper);
    }
}
