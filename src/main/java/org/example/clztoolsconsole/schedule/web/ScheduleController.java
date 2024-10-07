package org.example.clztoolsconsole.schedule.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.Schedule;
import org.example.clztoolsconsole.schedule.mapper.ScheduleMapper;
import org.example.clztoolsconsole.schedule.service.ScheduleService;
import org.example.clztoolsconsole.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController extends BaseController<ScheduleService, ScheduleMapper, Schedule> {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        super(scheduleService);
        this.scheduleService = scheduleService;
    }
}
