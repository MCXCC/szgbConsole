package org.szgb.console.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szgb.console.schedule.entity.SchedulePlan;
import org.szgb.console.schedule.mapper.SchedulePlanMapper;
import org.szgb.console.sys.user.mapper.SysUserMapper;
import org.szgb.core.base.service.BaseService;

import java.util.List;

@Slf4j
@Service
public class SchedulePlanService extends BaseService<SchedulePlanMapper, SchedulePlan> {
    private final SysUserMapper sysUserMapper;

    @Autowired
    public SchedulePlanService(SchedulePlanMapper schedulePlanMapper, SysUserMapper sysUserMapper) {
        super(schedulePlanMapper);
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public List<SchedulePlan> findList(SchedulePlan entity) {
        List<SchedulePlan> list = super.findList(entity);
        list.forEach(schedulePlan -> {
            if (schedulePlan.getGroupMemberIds() != null) {
                schedulePlan.setGroupMember(sysUserMapper.getByIdList(schedulePlan.getGroupMemberIds().split(",")));
            }
        });
        return list;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(List<SchedulePlan> entityList) {
        super.delete(entityList);
    }
}
