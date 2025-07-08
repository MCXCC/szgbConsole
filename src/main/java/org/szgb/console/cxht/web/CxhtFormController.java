package org.szgb.console.cxht.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.cxht.entity.CxhtForm;
import org.szgb.console.cxht.mapper.CxhtFormMapper;
import org.szgb.console.cxht.service.CxhtFormService;
import org.szgb.core.base.web.BaseController;

@Slf4j
@RestController
@RequestMapping(value = "/cxht/form")
public class CxhtFormController extends BaseController<CxhtFormService, CxhtFormMapper, CxhtForm> {

    @Autowired
    public CxhtFormController(CxhtFormService cxhtFormService) {
        super(cxhtFormService);
    }
}
