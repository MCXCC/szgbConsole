package org.szgb.console.sys.dict.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.dict.entity.SysDict;
import org.szgb.core.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDictMapper extends BaseMapper<SysDict> {
}
