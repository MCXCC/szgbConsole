package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.console.schedule.mapper.SchedulePlanMapper;
import org.szgb.core.base.service.BaseService;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SchedulePlanService extends BaseService<SchedulePlanMapper, SchedulePlan> {

    @Autowired
    public SchedulePlanService(SchedulePlanMapper schedulePlanMapper) {
        super(schedulePlanMapper);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(List<SchedulePlan> entityList) {
        super.delete(entityList);
    }
}
