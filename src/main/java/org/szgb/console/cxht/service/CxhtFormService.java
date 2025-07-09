package org.szgb.console.cxht.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.cxht.entity.CxhtForm;
import org.szgb.console.cxht.mapper.CxhtFormMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class CxhtFormService extends BaseService<CxhtFormMapper, CxhtForm> {
    @Autowired
    public CxhtFormService(CxhtFormMapper cxhtFormMapper) {
        super(cxhtFormMapper);
    }

    @Transactional(readOnly = true)
    public CxhtForm getForItemByEquipment(String equipmentId) {
        return mapper.getForItemByEquipment(equipmentId);
    }
}
