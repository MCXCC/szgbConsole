package org.example.clztoolsconsole.certification.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.certification.entity.Certification;
import org.example.clztoolsconsole.certification.mapper.CertificationMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CertificationService extends BaseService<CertificationMapper, Certification> {
    private final CertificationMapper certificationMapper;

    @Autowired
    public CertificationService(CertificationMapper certificationMapper) {
        super(certificationMapper);
        this.certificationMapper = certificationMapper;
    }
}
