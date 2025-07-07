package org.szgb.console.sys.line.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.szgb.console.sys.line.entity.SysLineLocationEquipment;
import org.szgb.core.base.mapper.BaseMapper;

import java.util.List;

@Mapper
@Repository
public interface SysLineLocationEquipmentMapper extends BaseMapper<SysLineLocationEquipment> {
    List<SysLineLocationEquipment> findListForTree(SysLineLocationEquipment lineLocationEquipment);
}
