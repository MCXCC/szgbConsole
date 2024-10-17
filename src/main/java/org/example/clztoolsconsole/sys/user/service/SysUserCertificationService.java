package org.example.clztoolsconsole.sys.user.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.user.entity.SysUserCertification;
import org.example.clztoolsconsole.sys.user.mapper.SysUserCertificationMapper;
import org.example.clztoolsconsole.utils.BaseService;
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
