package org.example.clztoolsconsole.sys.dict.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.dict.entity.SysDictChildren;
import org.example.clztoolsconsole.sys.dict.mapper.SysDictChildrenMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysDictChildrenService extends BaseService<SysDictChildrenMapper, SysDictChildren> {
    private final SysDictChildrenMapper sysDictChildrenMapper;

    @Autowired
    public SysDictChildrenService(SysDictChildrenMapper sysDictChildrenMapper) {
        super(sysDictChildrenMapper);
        this.sysDictChildrenMapper = sysDictChildrenMapper;
    }
}
