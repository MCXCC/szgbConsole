package org.szgb.console.sys.user.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.user.entity.SysUserCertification;
import org.szgb.console.sys.user.mapper.SysUserCertificationMapper;
import org.szgb.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysUserCertificationService extends BaseService<SysUserCertificationMapper, SysUserCertification> {

    @Autowired
    public SysUserCertificationService(SysUserCertificationMapper sysUserCertificationMapper) {
        super(sysUserCertificationMapper);
    }
}
