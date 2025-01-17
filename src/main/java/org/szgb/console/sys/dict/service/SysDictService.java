package org.szgb.console.sys.dict.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.sys.dict.entity.SysDict;
import org.szgb.console.sys.dict.entity.SysDictChildren;
import org.szgb.console.sys.dict.mapper.SysDictMapper;
import org.szgb.console.sys.line.entity.SysLineLocation;
import org.szgb.core.base.service.BaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        if (dictList == null || dictList.isEmpty()) {
            return null;
        }

        if (childrenList == null || childrenList.isEmpty()) {
            return dictList;
        }

        // 处理子级字典列表，将其与父级字典列表结合形成树形结构
        Map<Integer, List<SysDictChildren>> childrenMap = new HashMap<>();
        childrenList.forEach(children -> {
            try {
                childrenMap.get(children.getDict().getId()).add(children);
            } catch (NullPointerException e) {
                childrenMap.put(children.getDict().getId(), new ArrayList<>());
                childrenMap.get(children.getDict().getId()).add(children);
            }
        });

        dictList.forEach(dict -> {
            dict.setChildren(childrenMap.get(dict.getId()));
        });

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
