package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szgb.console.schedule.entity.SchedulePlanType;
import org.szgb.console.schedule.mapper.SchedulePlanTypeMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class SchedulePlanTypeService extends BaseService<SchedulePlanTypeMapper, SchedulePlanType> {
    @Autowired
    public SchedulePlanTypeService(SchedulePlanTypeMapper schedulePlanTypeMapper) {
        super(schedulePlanTypeMapper);
    }
}
