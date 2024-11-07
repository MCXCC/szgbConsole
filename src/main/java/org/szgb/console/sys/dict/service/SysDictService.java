package org.szgb.console.sys.dict.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.sys.dict.entity.SysDict;
import org.szgb.console.sys.dict.entity.SysDictChildren;
import org.szgb.console.sys.dict.mapper.SysDictMapper;
import org.szgb.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SysDictService extends BaseService<SysDictMapper, SysDict> {
    private final SysDictChildrenService sysDictChildrenService;

    @Autowired
    public SysDictService(SysDictMapper sysDictMapper, SysDictChildrenService sysDictChildrenService) {
        super(sysDictMapper);
        this.sysDictChildrenService = sysDictChildrenService;
    }

    @Transactional(readOnly = true)
    public List<SysDict> findTreeList() {
        // 查询父级字典列表
        List<SysDict> dictList = mapper.findList(new SysDict());

        // 查询子级字典列表
        List<SysDictChildren> childrenList = sysDictChildrenService.findList(new SysDictChildren());

        // 处理子级字典列表，将其与父级字典列表结合形成树形结构
        if (childrenList != null) {
            for (SysDictChildren child : childrenList) {
                dictList.stream()
                        .filter(dict -> dict.getId().equals(child.getDict().getId()))
                        .findFirst().ifPresent(parent -> {
                            try {
                                parent.getDictChildren().add(child);
                            } catch (NullPointerException e) {
                                parent.setDictChildren(new ArrayList<>());
                                parent.getDictChildren().add(child);
                            }
                        });
            }
        }
        return dictList;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            int i = Integer.parseInt(s);
            SysDictChildren sysDictChildren = new SysDictChildren();
            sysDictChildren.setDict(new SysDict(i));
            sysDictChildrenService.delete(sysDictChildrenService.findList(sysDictChildren));
            mapper.delete(i);
        }
    }
}
