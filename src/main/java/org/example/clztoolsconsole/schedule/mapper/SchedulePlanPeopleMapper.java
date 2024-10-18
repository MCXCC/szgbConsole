package org.example.clztoolsconsole.schedule.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.schedule.entity.SchedulePlanPeople;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SchedulePlanPeopleMapper extends BaseMapper<SchedulePlanPeople> {
}
