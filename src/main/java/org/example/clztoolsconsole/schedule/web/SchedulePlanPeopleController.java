package org.example.clztoolsconsole.schedule.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.SchedulePlanPeople;
import org.example.clztoolsconsole.schedule.mapper.SchedulePlanPeopleMapper;
import org.example.clztoolsconsole.schedule.service.SchedulePlanPeopleService;
import org.example.clztoolsconsole.utils.BaseController;
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
