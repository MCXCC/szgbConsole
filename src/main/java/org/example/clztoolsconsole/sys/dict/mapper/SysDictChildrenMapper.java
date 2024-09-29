package org.example.clztoolsconsole.sys.dict.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.clztoolsconsole.sys.dict.entity.SysDictChildren;
import org.example.clztoolsconsole.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDictChildrenMapper extends BaseMapper<SysDictChildren> {
}
