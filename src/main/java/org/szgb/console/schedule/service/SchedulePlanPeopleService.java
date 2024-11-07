package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.console.schedule.mapper.SchedulePlanPeopleMapper;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.console.sys.user.service.SysUserService;
import org.szgb.core.base.service.BaseService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
public class SchedulePlanPeopleService extends BaseService<SchedulePlanPeopleMapper, SchedulePlanPeople> {
    private final SysUserService sysUserService;
    private final SchedulePlanService schedulePlanService;

    @Lazy
    @Autowired
    public SchedulePlanPeopleService(
            SchedulePlanPeopleMapper schedulePlanPeopleMapper, SysUserService sysUserService,
            SchedulePlanService schedulePlanService) {
        super(schedulePlanPeopleMapper);
        this.sysUserService = sysUserService;
        this.schedulePlanService = schedulePlanService;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(List<SchedulePlanPeople> entityList) {
        super.delete(entityList);
    }

    @Transactional(readOnly = false)
    public void deleteBySchedulePlanId(int schedulePlanId) {
        mapper.deleteBySchedulePlanId(schedulePlanId);
    }

    @Override
    @Transactional(readOnly = false)
    public SchedulePlanPeople save(SchedulePlanPeople entity) {
        entity = super.save(entity);
        entity = get(entity);
        SysUser user = sysUserService.get(entity.getUser());
        LocalDate givenDate =
                entity.getSchedulePlan().getSchedule().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        if (ChronoUnit.DAYS.between(givenDate, yesterday) != 0) {
            user.setScheduleDayCount(0);
            user.setScheduleNightCount(0);
        } else if (entity.getType() == 1 || entity.getType() == 2) {
            user.setScheduleDayCount(user.getScheduleDayCount() + 1);
            user.setScheduleNightCount(0);
        } else if (entity.getType() == 3) {
            user.setScheduleDayCount(user.getScheduleDayCount() + 1);
            user.setScheduleNightCount(user.getScheduleNightCount() + 1);
        }
        user.setScheduleLastDay(entity.getSchedulePlan().getSchedule().getDate());
        sysUserService.save(user);
        return entity;
    }
}
