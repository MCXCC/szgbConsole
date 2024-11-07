package org.szgb.console.sys.certification.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.certification.entity.SysCertification;
import org.szgb.console.sys.certification.mapper.SysCertificationMapper;
import org.szgb.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysCertificationService extends BaseService<SysCertificationMapper, SysCertification> {

    @Autowired
    public SysCertificationService(SysCertificationMapper sysCertificationMapper) {
        super(sysCertificationMapper);
    }
}
