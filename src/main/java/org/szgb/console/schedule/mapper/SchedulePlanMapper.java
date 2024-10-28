package org.szgb.console.schedule.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SchedulePlanMapper extends BaseMapper<SchedulePlan> {
}
