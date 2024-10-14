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

        // 如果查询结果为空，则返回空列表
        if (dictList == null) {
            dictList = new ArrayList<>();
        }

        // 处理子级字典列表，将其与父级字典列表结合形成树形结构
        if (childrenList != null) {
            for (SysDictChildren child : childrenList) {
                // 假设 SysDict 类中有 addChild 方法用于添加子节点
                dictList.stream()
                        .filter(dict -> dict.getId().equals(child.getDict().getId()))
                        .findFirst().ifPresent(parent -> {
                            if (parent.getDictChildren() == null) {
                                parent.setDictChildren(new ArrayList<SysDictChildren>());
                            }
                            parent.getDictChildren().add(child);
                        });
            }
        }
        return dictList;
    }
}
