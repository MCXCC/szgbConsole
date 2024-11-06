package org.szgb.console.certification.web;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.certification.entity.Certification;
import org.szgb.console.certification.mapper.CertificationMapper;
import org.szgb.console.certification.service.CertificationService;
import org.szgb.console.sys.user.entity.SysUserCertification;
import org.szgb.console.sys.user.service.SysUserCertificationService;
import org.szgb.core.base.web.BaseController;
import org.szgb.core.utils.AjaxJson;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/certification")
public class CertificationController extends BaseController<CertificationService, CertificationMapper, Certification> {
    private final SysUserCertificationService sysUserCertificationService;

    @Autowired
    public CertificationController(CertificationService certificationService, SysUserCertificationService sysUserCertificationService) {
        super(certificationService);
        this.sysUserCertificationService = sysUserCertificationService;
    }

    @Override
    @DeleteMapping("/delete")
    public AjaxJson deleteByIds(String ids, HttpServletRequest request, HttpServletResponse response) {
        for (String s : ids.split(",")) {
            int i = Integer.parseInt(s);
            SysUserCertification sysUserCertification = new SysUserCertification();
            sysUserCertification.setCertification(new Certification(i));
            List<SysUserCertification> list = sysUserCertificationService.findList(sysUserCertification);
            if (!(list == null || list.isEmpty())) {
                return AjaxJson.error("存在拥有该证件的用户", HttpStatus.HTTP_BAD_REQUEST, request, response);
            }
        }
        return super.deleteByIds(ids, request, response);
    }
}
