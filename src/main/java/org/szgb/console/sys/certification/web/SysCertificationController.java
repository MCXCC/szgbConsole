package org.szgb.console.sys.certification.web;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.sys.certification.entity.SysCertification;
import org.szgb.console.sys.certification.mapper.SysCertificationMapper;
import org.szgb.console.sys.certification.service.SysCertificationService;
import org.szgb.console.sys.user.entity.SysUserCertification;
import org.szgb.console.sys.user.service.SysUserCertificationService;
import org.szgb.core.base.web.BaseController;
import org.szgb.core.utils.AjaxJson;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/certification")
public class SysCertificationController extends BaseController<SysCertificationService, SysCertificationMapper, SysCertification> {
    private final SysUserCertificationService sysUserCertificationService;

    @Autowired
    public SysCertificationController(SysCertificationService sysCertificationService, SysUserCertificationService sysUserCertificationService) {
        super(sysCertificationService);
        this.sysUserCertificationService = sysUserCertificationService;
    }

    @Override
    @DeleteMapping("/delete")
    public AjaxJson deleteByIds(String ids, HttpServletRequest request, HttpServletResponse response) {
        for (String s : ids.split(",")) {
            int i = Integer.parseInt(s);
            SysUserCertification sysUserCertification = new SysUserCertification();
            sysUserCertification.setSysCertification(new SysCertification(i));
            List<SysUserCertification> list = sysUserCertificationService.findList(sysUserCertification);
            if (!(list == null || list.isEmpty())) {
                return AjaxJson.error("存在拥有该证件的用户", HttpStatus.HTTP_BAD_REQUEST, request, response);
            }
        }
        return super.deleteByIds(ids, request, response);
    }
}
