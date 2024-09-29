package org.example.clztoolsconsole.sys.dict.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.dict.entity.SysDict;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDictMapper extends BaseMapper<SysDict> {
}
