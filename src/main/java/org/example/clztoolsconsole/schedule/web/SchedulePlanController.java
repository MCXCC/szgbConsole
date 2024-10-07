package org.example.clztoolsconsole.schedule.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.schedule.service.SchedulePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/schedule")
public class SchedulePlanController {
    private final SchedulePlanService schedulePlanService;

    @Autowired
    public SchedulePlanController(SchedulePlanService schedulePlanService) {
        super(schedulePlanService);
        this.schedulePlanService = schedulePlanService;
    }
}
