package org.szgb.console.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.console.schedule.mapper.SchedulePlanPeopleMapper;
import org.szgb.core.base.service.BaseService;

import java.util.List;

@Service
public class SchedulePlanPeopleService extends BaseService<SchedulePlanPeopleMapper, SchedulePlanPeople> {
    @Autowired
    public SchedulePlanPeopleService(
            SchedulePlanPeopleMapper schedulePlanPeopleMapper) {
        super(schedulePlanPeopleMapper);
    }

    @Transactional(readOnly = true)
    public List<SchedulePlanPeople> findListByPlanId(int schedulePlanId) {
        return mapper.findListByPlanId(schedulePlanId);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(List<SchedulePlanPeople> entityList) {
        super.delete(entityList);
    }

    @Override
    protected void delete(SchedulePlanPeople entity) {
        super.delete(entity);
    }

    @Transactional(readOnly = false)
    public void deleteBySchedulePlanId(int schedulePlanId) {
        mapper.deleteBySchedulePlanId(schedulePlanId);
    }
}
