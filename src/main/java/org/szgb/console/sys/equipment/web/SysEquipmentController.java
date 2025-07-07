package org.szgb.console.sys.equipment.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.sys.equipment.entity.SysEquipment;
import org.szgb.console.sys.equipment.mapper.SysEquipmentMapper;
import org.szgb.console.sys.equipment.service.SysEquipmentService;
import org.szgb.core.base.web.BaseController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/equipment")
public class SysEquipmentController extends BaseController<SysEquipmentService, SysEquipmentMapper,SysEquipment>{
    @Autowired
    public SysEquipmentController(SysEquipmentService sysEquipmentService) {
        super(sysEquipmentService);
    }
}
