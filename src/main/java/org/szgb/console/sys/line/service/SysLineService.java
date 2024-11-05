package org.szgb.console.sys.line.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szgb.console.sys.line.entity.SysLine;
import org.szgb.console.sys.line.mapper.SysLineMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class SysLineService extends BaseService<SysLineMapper, SysLine> {

    @Autowired
    public SysLineService(SysLineMapper mapper) {
        super(mapper);
    }
}
