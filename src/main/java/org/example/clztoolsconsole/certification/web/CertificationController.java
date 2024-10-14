package org.example.clztoolsconsole.certification.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.certification.entity.Certification;
import org.example.clztoolsconsole.certification.mapper.CertificationMapper;
import org.example.clztoolsconsole.certification.service.CertificationService;
import org.example.clztoolsconsole.utils.BaseController;
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
