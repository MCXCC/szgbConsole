package org.szgb.console.sys.line.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.sys.line.entity.SysLine;
import org.szgb.console.sys.line.entity.SysLineLocation;
import org.szgb.console.sys.line.mapper.SysLineLocationMapper;
import org.szgb.console.sys.line.mapper.SysLineMapper;
import org.szgb.core.base.service.BaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysLineService extends BaseService<SysLineMapper, SysLine> {

    private final SysLineLocationMapper sysLineLocationMapper;

    @Autowired
    public SysLineService(SysLineMapper mapper, SysLineLocationMapper sysLineLocationMapper) {
        super(mapper);
        this.sysLineLocationMapper = sysLineLocationMapper;
    }

    @Transactional(readOnly = true)
    public List<SysLine> findTreeList() {
        // 查询线路列表
        List<SysLine> lineList = mapper.findList(new SysLine());

        if (lineList == null || lineList.isEmpty()) {
            return null;
        }

        // 查询站点列表
        List<SysLineLocation> locationList = sysLineLocationMapper.findList(new SysLineLocation());

        if (locationList == null || locationList.isEmpty()) {
            return lineList;
        }

        // 插入站点列表到线路列表中
        Map<Integer, List<SysLineLocation>> locationMap = new HashMap<>();
        locationList.forEach(location -> {
            try {
                locationMap.get(location.getLine().getId()).add(location);
            } catch (NullPointerException e) {
                locationMap.put(location.getLine().getId(), new ArrayList<>());
                locationMap.get(location.getLine().getId()).add(location);
            }
        });

        lineList.forEach(line -> {
            line.setLineLocationList(locationMap.get(line.getId()));
        });

        return lineList;
    }
}
