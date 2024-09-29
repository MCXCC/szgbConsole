package org.example.clztoolsconsole.sys.dict.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.dict.entity.SysDict;
import org.example.clztoolsconsole.sys.dict.mapper.SysDictMapper;
import org.example.clztoolsconsole.sys.dict.service.SysDictService;
import org.example.clztoolsconsole.utils.AjaxJson;
import org.example.clztoolsconsole.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sys/dict")
public class SysDictController extends BaseController<SysDictService, SysDictMapper, SysDict> {
    private final SysDictService sysDictService;

    @Autowired
    public SysDictController(SysDictService sysDictService) {
        super(sysDictService);
        this.sysDictService = sysDictService;
    }

    @PostMapping("/treeList")
    public AjaxJson getTreeList(HttpServletRequest request, HttpServletResponse response) {
        return AjaxJson.success(request, response).put("dictTree", sysDictService.findTreeList());
    }
}
