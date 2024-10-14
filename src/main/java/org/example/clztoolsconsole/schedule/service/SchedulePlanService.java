package org.example.clztoolsconsole.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.SchedulePlan;
import org.example.clztoolsconsole.schedule.mapper.SchedulePlanMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SchedulePlanService extends BaseService<SchedulePlanMapper, SchedulePlan> {

    @Autowired
    public SchedulePlanService(SchedulePlanMapper schedulePlanMapper) {
        super(schedulePlanMapper);
    }
}
