package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.schedule.entity.Schedule;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.console.schedule.mapper.ScheduleMapper;
import org.szgb.core.base.service.BaseService;

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
    @Transactional(readOnly = false)
    public Schedule save(Schedule schedule) {
        schedule = super.save(schedule);
        if (schedule.getSchedulePlanList() != null) {
            for (SchedulePlan schedulePlan : schedule.getSchedulePlanList()) {
                schedulePlan.setSchedule(schedule);
                schedulePlan.setUpdatedBy(schedule.getUpdatedBy());
                schedulePlanService.save(schedulePlan);
            }
        }
        return schedule;
    }

    @Override
    @Transactional(readOnly = true)
    public Schedule get(Schedule schedule) {
        Schedule t = super.get(schedule);
        if (t != null) {
            SchedulePlan schedulePlan = new SchedulePlan();
            schedulePlan.setSchedule(schedule);
            t.setSchedulePlanList(schedulePlanService.findList(schedulePlan));
        }
        return t;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            SchedulePlan schedulePlan = new SchedulePlan();
            schedulePlan.setSchedule(new Schedule(s));
            schedulePlanService.delete(schedulePlanService.findList(schedulePlan));
            mapper.delete(s);
        }
    }
}
