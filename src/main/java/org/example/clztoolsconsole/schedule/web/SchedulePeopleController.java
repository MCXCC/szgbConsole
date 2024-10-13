package org.example.clztoolsconsole.schedule.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.entity.SchedulePeople;
import org.example.clztoolsconsole.schedule.mapper.SchedulePeopleMapper;
import org.example.clztoolsconsole.schedule.service.SchedulePeopleService;
import org.example.clztoolsconsole.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/schedule/people")
public class SchedulePeopleController extends BaseController<SchedulePeopleService, SchedulePeopleMapper, SchedulePeople> {
    @Autowired
    public SchedulePeopleController(SchedulePeopleService schedulePeopleService) {
        super(schedulePeopleService);
    }
}
