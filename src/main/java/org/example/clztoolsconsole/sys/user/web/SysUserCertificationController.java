package org.example.clztoolsconsole.sys.user.web;

import org.example.clztoolsconsole.sys.user.entity.SysUserCertification;
import org.example.clztoolsconsole.sys.user.mapper.SysUserCertificationMapper;
import org.example.clztoolsconsole.sys.user.service.SysUserCertificationService;
import org.example.clztoolsconsole.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sys/user/certification")
public class SysUserCertificationController extends BaseController<SysUserCertificationService, SysUserCertificationMapper,
        SysUserCertification> {

    @Autowired
    public SysUserCertificationController(SysUserCertificationService sysUserCertificationService) {
        super(sysUserCertificationService);
    }
}
