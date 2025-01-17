package org.szgb.console.schedule.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.schedule.entity.SchedulePlanType;
import org.szgb.console.schedule.mapper.SchedulePlanTypeMapper;
import org.szgb.console.schedule.service.SchedulePlanTypeService;
import org.szgb.core.base.web.BaseController;

@RestController
@RequestMapping(value = "/schedule/plan/type")
public class SchedulePlanTypeController extends BaseController<SchedulePlanTypeService, SchedulePlanTypeMapper, SchedulePlanType> {
    @Autowired
    public SchedulePlanTypeController(SchedulePlanTypeService schedulePlanTypeService) {
        super(schedulePlanTypeService);
    }
}
