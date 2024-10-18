package org.example.clztoolsconsole.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.SchedulePlanPeople;
import org.example.clztoolsconsole.schedule.mapper.SchedulePlanPeopleMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SchedulePlanPeopleService extends BaseService<SchedulePlanPeopleMapper, SchedulePlanPeople> {

    @Autowired
    public SchedulePlanPeopleService(SchedulePlanPeopleMapper schedulePlanPeopleMapper) {
        super(schedulePlanPeopleMapper);
    }
}
