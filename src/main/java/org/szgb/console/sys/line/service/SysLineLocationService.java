package org.szgb.console.sys.line.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szgb.console.sys.line.entity.SysLineLocation;
import org.szgb.console.sys.line.mapper.SysLineLocationMapper;
import org.szgb.core.base.service.BaseService;

@Slf4j
@Service
public class SysLineLocationService extends BaseService<SysLineLocationMapper, SysLineLocation> {
    @Autowired
    public SysLineLocationService(SysLineLocationMapper mapper) {
        super(mapper);
    }
}
