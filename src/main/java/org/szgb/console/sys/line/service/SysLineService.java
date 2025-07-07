package org.szgb.console.sys.line.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.sys.line.entity.SysLine;
import org.szgb.console.sys.line.mapper.SysLineMapper;
import org.szgb.core.base.service.BaseService;

import java.util.List;

@Slf4j
@Service
public class SysLineService extends BaseService<SysLineMapper, SysLine> {
    @Autowired
    public SysLineService(SysLineMapper mapper) {
        super(mapper);
    }

    @Transactional(readOnly = true)
    public List<SysLine> findListForEquipment(SysLine sysLine) {
        return mapper.findListForEquipment(sysLine);
    }
}
