package org.szgb.console.sys.user.web;

import org.szgb.console.sys.user.entity.SysUserCertification;
import org.szgb.console.sys.user.mapper.SysUserCertificationMapper;
import org.szgb.console.sys.user.service.SysUserCertificationService;
import org.szgb.console.utils.BaseController;
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
