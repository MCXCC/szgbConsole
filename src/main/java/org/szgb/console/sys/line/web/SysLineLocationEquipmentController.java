package org.szgb.console.sys.line.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.sys.line.entity.SysLineLocationEquipment;
import org.szgb.console.sys.line.mapper.SysLineLocationEquipmentMapper;
import org.szgb.console.sys.line.service.SysLineLocationEquipmentService;
import org.szgb.core.base.web.BaseController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/line/location/equipment")
public class SysLineLocationEquipmentController extends BaseController<SysLineLocationEquipmentService, SysLineLocationEquipmentMapper, SysLineLocationEquipment> {
    @Autowired
    public SysLineLocationEquipmentController(SysLineLocationEquipmentService sysLineLocationEquipmentService) {
        super(sysLineLocationEquipmentService);
    }
}
