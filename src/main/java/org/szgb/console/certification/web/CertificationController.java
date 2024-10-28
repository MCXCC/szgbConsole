package org.szgb.console.certification.web;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.certification.entity.Certification;
import org.szgb.console.certification.mapper.CertificationMapper;
import org.szgb.console.certification.service.CertificationService;
import org.szgb.core.base.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/certification")
public class CertificationController extends BaseController<CertificationService, CertificationMapper, Certification> {

    @Autowired
    public CertificationController(CertificationService certificationService) {
        super(certificationService);
    }}
