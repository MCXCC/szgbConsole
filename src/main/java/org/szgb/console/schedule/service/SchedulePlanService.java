package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.console.schedule.mapper.SchedulePlanMapper;
import org.szgb.core.base.service.BaseService;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SchedulePlanService extends BaseService<SchedulePlanMapper, SchedulePlan> {
    private final SchedulePlanPeopleService schedulePlanPeopleService;

    @Autowired
    public SchedulePlanService(SchedulePlanMapper schedulePlanMapper, SchedulePlanPeopleService schedulePlanPeopleService) {
        super(schedulePlanMapper);
        this.schedulePlanPeopleService = schedulePlanPeopleService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SchedulePlan> findList(SchedulePlan schedulePlan) {
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
    public SchedulePlan save(SchedulePlan schedulePlan) {
        List<SchedulePlanPeople> schedulePeopleList = schedulePlan.getSchedulePeopleList();
        List<SchedulePlanPeople> oldList = schedulePlanPeopleService.findListByPlanId(schedulePlan.getId());
        if (schedulePeopleList != null) {
            for (SchedulePlanPeople schedulePlanPeople : schedulePeopleList) {
                // 判断是否是新数据
                if (schedulePlanPeople.getId() == null) {
                    schedulePlanPeople.setSchedulePlan(schedulePlan);
                    schedulePlanPeople.setUpdatedBy(schedulePlan.getUpdatedBy());
                    schedulePlanPeopleService.save(schedulePlanPeople);
                    continue;
                }

                // 判断是老数据
                boolean isOld = false;
                for (SchedulePlanPeople old : oldList) {
                    if (Objects.equals(old.getId(), schedulePlanPeople.getId())) {
                        isOld = true;
                        schedulePlanPeople.setSchedulePlan(schedulePlan);
                        schedulePlanPeople.setUpdatedBy(schedulePlan.getUpdatedBy());
                        schedulePlanPeopleService.save(schedulePlanPeople);
                        break; // 退出循环
                    }
                }
                if (isOld) {
                    continue;
                }

                // 删除已删除的数据
                schedulePlanPeopleService.delete(schedulePlanPeople);

            }
        }
        return super.save(schedulePlan);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(List<SchedulePlan> entityList) {
        super.delete(entityList);
    }

    @Override
    protected void delete(int id) {
        schedulePlanPeopleService.deleteBySchedulePlanId(id);
        super.delete(id);
    }
}
