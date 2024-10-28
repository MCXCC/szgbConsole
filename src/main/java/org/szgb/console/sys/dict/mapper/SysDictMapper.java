package org.szgb.console.sys.dict.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.szgb.console.sys.dict.entity.SysDict;
import org.szgb.console.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDictMapper extends BaseMapper<SysDict> {
}
