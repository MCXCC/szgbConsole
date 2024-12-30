package org.szgb.console.schedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

/**
 * 班次人员
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SchedulePlanPeople extends BeanEntity<SchedulePlanPeople> {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 班次
     */
    @JsonIgnore
    private SchedulePlan schedulePlan;
    /**
     * 人员
     */
    private SysUser user;
    /**
     * 人员类型
     */
    private int type;
}
