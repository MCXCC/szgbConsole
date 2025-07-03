package org.szgb.console.sys.dict.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.sys.dict.entity.SysDict;
import org.szgb.console.sys.dict.mapper.SysDictMapper;
import org.szgb.console.sys.dict.service.SysDictService;
import org.szgb.core.base.web.BaseController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/dict")
public class SysDictController extends BaseController<SysDictService, SysDictMapper, SysDict> {
    @Autowired
    public SysDictController(SysDictService sysDictService) {
        super(sysDictService);
    }
}
