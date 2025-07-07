package org.szgb.console.sys.line.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szgb.console.sys.line.entity.SysLineLocationEquipment;
import org.szgb.console.sys.line.mapper.SysLineLocationEquipmentMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class SysLineLocationEquipmentService extends BaseService<SysLineLocationEquipmentMapper, SysLineLocationEquipment> {
    @Autowired
    public SysLineLocationEquipmentService(SysLineLocationEquipmentMapper sysLineLocationEquipmentMapper) {
        super(sysLineLocationEquipmentMapper);
    }
}
