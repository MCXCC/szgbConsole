package org.szgb.console.cxht.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.szgb.console.cxht.entity.CxhtFormItem;
import org.szgb.console.cxht.mapper.CxhtFormItemMapper;
import org.szgb.console.cxht.service.CxhtFormItemService;
import org.szgb.core.base.web.BaseController;

@Slf4j
@RestController
@RequestMapping(value = "/cxht/form/item")
public class CxhtFormItemController extends BaseController<CxhtFormItemService, CxhtFormItemMapper, CxhtFormItem> {
    @Autowired
    public CxhtFormItemController(CxhtFormItemService cxhtFormItemService) {
        super(cxhtFormItemService);
    }
}
