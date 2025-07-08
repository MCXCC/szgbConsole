package org.szgb.console.cxht.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szgb.console.cxht.entity.CxhtFormItem;
import org.szgb.console.cxht.mapper.CxhtFormItemMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class CxhtFormItemService extends BaseService<CxhtFormItemMapper, CxhtFormItem> {
    @Autowired
    public CxhtFormItemService(CxhtFormItemMapper cxhtFormItemMapper) {
        super(cxhtFormItemMapper);
    }
}
