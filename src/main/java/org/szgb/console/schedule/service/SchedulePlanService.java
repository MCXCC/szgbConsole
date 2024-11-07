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
        entity = super.save(entity);
        List<SchedulePlanPeople> schedulePeopleList = entity.getSchedulePeopleList();
        if (schedulePeopleList != null) {
            for (SchedulePlanPeople schedulePlanPeople : schedulePeopleList) {
                schedulePlanPeople.setSchedulePlan(entity);
                schedulePlanPeople.setUpdatedBy(entity.getUpdatedBy());
                schedulePlanPeopleService.save(schedulePlanPeople);
            }
        }
        return entity;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(List<SchedulePlan> entityList){
        for (SchedulePlan entity : entityList) {
            schedulePlanPeopleService.deleteBySchedulePlanId(entity.getId());
            mapper.delete(entity);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            int i = Integer.parseInt(s);
            schedulePlanPeopleService.deleteBySchedulePlanId(i);
            mapper.delete(i);
        }
    }
}
