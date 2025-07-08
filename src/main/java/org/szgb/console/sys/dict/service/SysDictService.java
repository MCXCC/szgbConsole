package org.szgb.console.sys.dict.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.sys.dict.entity.SysDict;
import org.szgb.console.sys.dict.entity.SysDictChildren;
import org.szgb.console.sys.dict.mapper.SysDictMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class SysDictService extends BaseService<SysDictMapper, SysDict> {
    private final SysDictChildrenService sysDictChildrenService;

    @Autowired
    public SysDictService(SysDictMapper sysDictMapper, SysDictChildrenService sysDictChildrenService) {
        super(sysDictMapper);
        this.sysDictChildrenService = sysDictChildrenService;
    }

    @Override
    @Transactional()
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            SysDictChildren sysDictChildren = new SysDictChildren();
            sysDictChildren.setDict(new SysDict(s));
            sysDictChildrenService.delete(sysDictChildrenService.findList(sysDictChildren));
            mapper.delete(s);
        }
    }
}
