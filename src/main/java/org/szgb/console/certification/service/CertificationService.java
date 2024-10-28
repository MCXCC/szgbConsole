package org.szgb.console.certification.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.certification.entity.Certification;
import org.szgb.console.certification.mapper.CertificationMapper;
import org.szgb.console.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CertificationService extends BaseService<CertificationMapper, Certification> {

    @Autowired
    public CertificationService(CertificationMapper certificationMapper) {
        super(certificationMapper);
    }
}
