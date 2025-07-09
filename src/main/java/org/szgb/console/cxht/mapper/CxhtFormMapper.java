package org.szgb.console.cxht.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.szgb.console.cxht.entity.CxhtForm;
import org.szgb.core.base.mapper.BaseMapper;

@Mapper
@Repository
public interface CxhtFormMapper extends BaseMapper<CxhtForm> {
    CxhtForm getForItemByEquipment(String equipmentId);
}
