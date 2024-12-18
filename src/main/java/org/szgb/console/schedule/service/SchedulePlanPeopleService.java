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
    @Autowired
    public SchedulePlanPeopleService(
            SchedulePlanPeopleMapper schedulePlanPeopleMapper) {
        super(schedulePlanPeopleMapper);
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
}
