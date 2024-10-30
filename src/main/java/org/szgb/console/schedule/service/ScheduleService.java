package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.schedule.entity.Schedule;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.console.schedule.mapper.ScheduleMapper;
import org.szgb.core.base.service.BaseService;
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
        Map<Boolean, String> saved = super.save(schedule);
        int id = Integer.parseInt(saved.get(true).split("=")[1]);
        if (schedule.getSchedulePlanList() != null) {
            for (SchedulePlan schedulePlan : schedule.getSchedulePlanList()) {
                Schedule schedule1 = new Schedule();
                schedule1.setId(id);
                schedulePlan.setSchedule(schedule1);
                schedulePlanService.save(schedulePlan);
            }
        }
        return saved;
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

    @Override
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            int i = Integer.parseInt(s);
            SchedulePlan schedulePlan = new SchedulePlan();
            schedulePlan.setSchedule(mapper.get(i));
            schedulePlanService.delete(schedulePlanService.findList(schedulePlan));
            mapper.delete(i);
        }
    }
}
