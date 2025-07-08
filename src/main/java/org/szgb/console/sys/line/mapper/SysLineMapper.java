package org.szgb.console.sys.line.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.szgb.console.sys.line.entity.SysLine;
import org.szgb.core.base.mapper.BaseMapper;

import java.util.List;

@Mapper
@Repository
public interface SysLineMapper extends BaseMapper<SysLine> {
    List<SysLine> findListForEquipment(SysLine sysLine);
    SysLine getDefault(String id);
}
