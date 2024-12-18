package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.console.schedule.mapper.SchedulePlanMapper;
import org.szgb.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SchedulePlanService extends BaseService<SchedulePlanMapper, SchedulePlan> {
    private final SchedulePlanPeopleService schedulePlanPeopleService;

    @Autowired
    public SchedulePlanService(SchedulePlanMapper schedulePlanMapper,
                               SchedulePlanPeopleService schedulePlanPeopleService) {
        super(schedulePlanMapper);
        this.schedulePlanPeopleService = schedulePlanPeopleService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SchedulePlan> findList(SchedulePlan schedulePlan){
        List<SchedulePlan> list = super.findList(schedulePlan);
        for (SchedulePlan t : list) {
            SchedulePlanPeople schedulePlanPeople = new SchedulePlanPeople();
            schedulePlanPeople.setSchedulePlan(t);
            t.setSchedulePeopleList(schedulePlanPeopleService.findList(schedulePlanPeople));
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public SchedulePlan get(SchedulePlan schedulePlan) {
        SchedulePlan t = super.get(schedulePlan);
        if (t != null) {
            SchedulePlanPeople schedulePlanPeople = new SchedulePlanPeople();
            schedulePlanPeople.setSchedulePlan(t);
            t.setSchedulePeopleList(schedulePlanPeopleService.findList(schedulePlanPeople));
        }
        return t;
    }

    @Override
    @Transactional(readOnly = false)
    public SchedulePlan save(SchedulePlan entity) {
        List<SchedulePlanPeople> schedulePeopleList = entity.getSchedulePeopleList();
        if (schedulePeopleList != null) {
            for (SchedulePlanPeople schedulePlanPeople : schedulePeopleList) {
                schedulePlanPeople.setSchedulePlan(entity);
                schedulePlanPeople.setUpdatedBy(entity.getUpdatedBy());
                schedulePlanPeopleService.save(schedulePlanPeople);
            }
        }
        entity = super.save(entity);
        return entity;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(List<SchedulePlan> entityList){
        super.delete(entityList);
    }

    @Override
    protected void delete(int id) {
        schedulePlanPeopleService.deleteBySchedulePlanId(id);
        super.delete(id);
    }
}
