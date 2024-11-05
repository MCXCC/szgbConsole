package org.szgb.console.sys.line.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.sys.line.entity.SysLineLocation;
import org.szgb.console.sys.line.mapper.SysLineLocationMapper;
import org.szgb.console.sys.line.service.SysLineLocationService;
import org.szgb.core.base.web.BaseController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/line/location")
public class SysLineLocationController extends BaseController<SysLineLocationService, SysLineLocationMapper,
        SysLineLocation> {
    @Autowired
    public SysLineLocationController(SysLineLocationService service) {
        super(service);
    }
}
