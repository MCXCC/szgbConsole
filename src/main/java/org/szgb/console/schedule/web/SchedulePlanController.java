package org.szgb.console.schedule.web;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.console.schedule.mapper.SchedulePlanMapper;
import org.szgb.console.schedule.service.SchedulePlanService;
import org.szgb.core.base.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/schedule/plan")
public class SchedulePlanController extends BaseController<SchedulePlanService, SchedulePlanMapper, SchedulePlan> {

    @Autowired
    public SchedulePlanController(SchedulePlanService schedulePlanService) {
        super(schedulePlanService);
    }
}
