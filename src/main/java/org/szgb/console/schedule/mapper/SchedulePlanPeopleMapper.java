package org.szgb.console.schedule.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.core.base.mapper.BaseMapper;

import java.util.List;

@Mapper
@Repository
public interface SchedulePlanPeopleMapper extends BaseMapper<SchedulePlanPeople> {
    void deleteBySchedulePlanId(int schedulePlanId);

    List<SchedulePlanPeople> findListByPlanId(int schedulePlanId);
}
