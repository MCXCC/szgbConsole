package org.szgb.console.sys.line.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.sys.line.entity.SysLine;
import org.szgb.console.sys.line.mapper.SysLineMapper;
import org.szgb.console.sys.line.service.SysLineService;
import org.szgb.core.base.web.BaseController;
import org.szgb.core.utils.AjaxJson;

@Slf4j
@RestController
@RequestMapping(value = "/sys/line")
public class SysLineController extends BaseController<SysLineService, SysLineMapper, SysLine> {
    @Autowired
    public SysLineController(SysLineService sysLineService) {
        super(sysLineService);
    }

    @PostMapping("/treeList")
    public AjaxJson getTreeList(HttpServletRequest request, HttpServletResponse response) {
        return AjaxJson.success(request, response).put("dictTree", service.findTreeList());
    }
}
