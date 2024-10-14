package org.example.clztoolsconsole.sys.dict.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.dict.entity.SysDict;
import org.example.clztoolsconsole.sys.dict.entity.SysDictChildren;
import org.example.clztoolsconsole.sys.dict.mapper.SysDictChildrenMapper;
import org.example.clztoolsconsole.sys.dict.mapper.SysDictMapper;
import org.example.clztoolsconsole.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SysDictService extends BaseService<SysDictMapper, SysDict> {
    private final SysDictMapper sysDictMapper;
    private final SysDictChildrenMapper sysDictChildrenMapper;

    @Autowired
    public SysDictService(SysDictMapper sysDictMapper, SysDictChildrenMapper sysDictChildrenMapper) {
        super(sysDictMapper);
        this.sysDictMapper = sysDictMapper;
        this.sysDictChildrenMapper = sysDictChildrenMapper;
    }

    public List<SysDict> findTreeList() {
        // 查询父级字典列表
        List<SysDict> dictList = sysDictMapper.findList(new SysDict());

        // 查询子级字典列表
        List<SysDictChildren> childrenList = sysDictChildrenMapper.findList(new SysDictChildren());

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
    public void delete(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            SysDict sysDict = new SysDict();
            sysDict.setId(Integer.parseInt(s));

            SysDictChildren sysDictChildren = new SysDictChildren();
            sysDictChildren.setDict(sysDict);
            List<SysDictChildren> list = sysDictChildrenMapper.findList(sysDictChildren);

            if(list != null){
                for (SysDictChildren sysDictChildren1 : list) {
                    sysDictChildrenMapper.delete(sysDictChildren1);
                }
            }
            sysDictMapper.delete(sysDict);
        }
    }
}
