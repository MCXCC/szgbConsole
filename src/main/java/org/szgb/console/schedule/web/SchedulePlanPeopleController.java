package org.szgb.console.schedule.web;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.console.schedule.mapper.SchedulePlanPeopleMapper;
import org.szgb.console.schedule.service.SchedulePlanPeopleService;
import org.szgb.core.base.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/schedule/plan/people")
public class SchedulePlanPeopleController extends BaseController<SchedulePlanPeopleService, SchedulePlanPeopleMapper, SchedulePlanPeople> {
    @Autowired
    public SchedulePlanPeopleController(SchedulePlanPeopleService schedulePeopleService) {
        super(schedulePeopleService);
    }
}
