package org.szgb.console.sys.dict.service;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.dict.entity.SysDictChildren;
import org.szgb.console.sys.dict.mapper.SysDictChildrenMapper;
import org.szgb.console.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SysDictChildrenService extends BaseService<SysDictChildrenMapper, SysDictChildren> {

    @Autowired
    public SysDictChildrenService(SysDictChildrenMapper sysDictChildrenMapper) {
        super(sysDictChildrenMapper);
    }

    @Override
    public void delete(List<SysDictChildren> entityList){
        super.delete(entityList);
    }
}
