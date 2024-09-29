package org.example.clztoolsconsole.sys.dict.web;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.dict.entity.SysDictChildren;
import org.example.clztoolsconsole.sys.dict.mapper.SysDictChildrenMapper;
import org.example.clztoolsconsole.sys.dict.service.SysDictChildrenService;
import org.example.clztoolsconsole.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/dict/Children")
public class SysDictChildrenController extends BaseController<SysDictChildrenService, SysDictChildrenMapper,
        SysDictChildren> {
    private final SysDictChildrenService sysDictChildrenService;

    @Autowired
    public SysDictChildrenController(SysDictChildrenService sysDictChildrenService) {
        super(sysDictChildrenService);
        this.sysDictChildrenService = sysDictChildrenService;
    }


}
