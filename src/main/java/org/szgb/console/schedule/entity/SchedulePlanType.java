package org.szgb.console.schedule.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;
import java.sql.Time;

/**
 * 排班类型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SchedulePlanType extends BeanEntity<SchedulePlanType> {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 排班类型名称
     */
    private String name;
    /**
     * 开始时间
     */
    private Time startAt;
    /**
     * 结束时间
     */
    private Time endAt;
}
