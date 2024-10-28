package org.szgb.console.schedule.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;


@EqualsAndHashCode(callSuper = true)
@Data
public class SchedulePlanPeople extends BeanEntity<SchedulePlanPeople> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SchedulePlan schedulePlan;
    private SysUser user;
    private int type;
}