package org.szgb.console.schedule.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.szgb.console.schedule.entity.SchedulePlanType;
import org.szgb.core.base.mapper.BaseMapper;

@Mapper
@Repository
public interface SchedulePlanTypeMapper extends BaseMapper<SchedulePlanType> {
}
