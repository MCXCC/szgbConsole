package org.szgb.console.sys.line.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.szgb.console.sys.line.entity.SysLineLocation;
import org.szgb.core.base.mapper.BaseMapper;

import java.util.List;

@Mapper
@Repository
public interface SysLineLocationMapper extends BaseMapper<SysLineLocation> {
    List<SysLineLocation> findListForEquipment(SysLineLocation sysLineLocation);
}
