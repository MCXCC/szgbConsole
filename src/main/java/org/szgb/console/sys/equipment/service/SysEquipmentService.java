package org.szgb.console.sys.equipment.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szgb.console.sys.equipment.entity.SysEquipment;
import org.szgb.console.sys.equipment.mapper.SysEquipmentMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class SysEquipmentService extends BaseService<SysEquipmentMapper, SysEquipment> {
    @Autowired
    public SysEquipmentService(SysEquipmentMapper sysEquipmentMapper) {
        super(sysEquipmentMapper);
    }
}
