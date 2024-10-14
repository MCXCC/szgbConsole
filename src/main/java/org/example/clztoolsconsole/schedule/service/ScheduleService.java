package org.example.clztoolsconsole.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.Schedule;
import org.example.clztoolsconsole.schedule.entity.SchedulePlan;
import org.example.clztoolsconsole.schedule.mapper.ScheduleMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class ScheduleService extends BaseService<ScheduleMapper, Schedule> {
    private final SchedulePlanService schedulePlanService;

    @Autowired
    public ScheduleService(ScheduleMapper scheduleMapper, SchedulePlanService schedulePlanService) {
        super(scheduleMapper);
        this.schedulePlanService = schedulePlanService;
    }

    @Override
    public Map<Boolean, String> save(Schedule schedule) {
        if (schedule.getSchedulePlanList() != null) {
            for (SchedulePlan schedulePlan : schedule.getSchedulePlanList()) {
                if (schedulePlan != null) {
                    schedulePlanService.save(schedulePlan);
                }
            }
        }
        return super.save(schedule);
    }

    @Override
    public Schedule get(Schedule schedule) {
        Schedule t = super.get(schedule);
        if (t != null) {
            SchedulePlan schedulePlan = new SchedulePlan();
            schedulePlan.setSchedule(schedule);
            t.setSchedulePlanList(schedulePlanService.findList(schedulePlan));
        }
        return t;
    }
}
