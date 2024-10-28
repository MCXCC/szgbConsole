package org.szgb.console.schedule.web;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.schedule.entity.Schedule;
import org.szgb.console.schedule.mapper.ScheduleMapper;
import org.szgb.console.schedule.service.ScheduleService;
import org.szgb.core.base.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController extends BaseController<ScheduleService, ScheduleMapper, Schedule> {

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        super(scheduleService);
    }
}
