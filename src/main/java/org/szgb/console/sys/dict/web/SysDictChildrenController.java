package org.szgb.console.sys.dict.web;

import lombok.extern.slf4j.Slf4j;
import org.szgb.console.sys.dict.entity.SysDictChildren;
import org.szgb.console.sys.dict.mapper.SysDictChildrenMapper;
import org.szgb.console.sys.dict.service.SysDictChildrenService;
import org.szgb.console.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/dict/children")
public class SysDictChildrenController extends BaseController<SysDictChildrenService, SysDictChildrenMapper,
        SysDictChildren> {

    @Autowired
    public SysDictChildrenController(SysDictChildrenService sysDictChildrenService) {
        super(sysDictChildrenService);
    }


}
