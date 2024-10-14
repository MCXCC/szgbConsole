package org.example.clztoolsconsole.user_certification.web;

import org.example.clztoolsconsole.user_certification.entity.UserCertification;
import org.example.clztoolsconsole.user_certification.mapper.UserCertificationMapper;
import org.example.clztoolsconsole.user_certification.service.UserCertificationService;
import org.example.clztoolsconsole.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userCertification")
public class UserCertificationController extends BaseController<UserCertificationService, UserCertificationMapper,
        UserCertification> {

    @Autowired
    public UserCertificationController(UserCertificationService userCertificationService) {
        super(userCertificationService);
    }
}
