package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.console.schedule.mapper.SchedulePlanPeopleMapper;
import org.szgb.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SchedulePlanPeopleService extends BaseService<SchedulePlanPeopleMapper, SchedulePlanPeople> {

    @Autowired
    public SchedulePlanPeopleService(SchedulePlanPeopleMapper schedulePlanPeopleMapper) {
        super(schedulePlanPeopleMapper);
    }

    @Override
    public void delete(List<SchedulePlanPeople> entityList){
        super.delete(entityList);
    }
}
