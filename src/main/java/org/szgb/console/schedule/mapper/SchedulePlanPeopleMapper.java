package org.szgb.console.schedule.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.schedule.entity.SchedulePlanPeople;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SchedulePlanPeopleMapper extends BaseMapper<SchedulePlanPeople> {
    void deleteBySchedulePlanId(int schedulePlanId);
}
