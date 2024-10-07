package org.example.clztoolsconsole.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.Schedule;
import org.example.clztoolsconsole.schedule.mapper.ScheduleMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduleService extends BaseService<ScheduleMapper, Schedule> {
    private final ScheduleMapper scheduleMapper;

    @Autowired
    public ScheduleService(ScheduleMapper scheduleMapper) {
        super(scheduleMapper);
        this.scheduleMapper = scheduleMapper;
    }
}
