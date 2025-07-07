package org.szgb.console.sys.equipment.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.szgb.console.sys.equipment.entity.SysEquipment;
import org.szgb.core.base.mapper.BaseMapper;

@Mapper
@Repository
public interface SysEquipmentMapper extends BaseMapper<SysEquipment> {
}
