package org.szgb.console.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.core.base.entity.BeanEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.util.Date;
import java.util.List;

/**
 * 排班消息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Schedule extends BeanEntity<Schedule> {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 部门
     */
    private SysDepartment department;
    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    /**
     * 800M号码
     */
    private String M800;
    /**
     * 白班领班
     */
    private String dayGaffer;
    /**
     * 白班抢修组长
     */
    private String dayLeader;
    /**
     * 白班信息联络
     */
    private String dayContact;
    /**
     * 白班物料准备
     */
    private String dayMateriel;
    /**
     * 白班其他人员
     */
    private String dayOther;
    /**
     * 夜班领班
     */
    private String nightGaffer;
    /**
     * 夜班抢修组长
     */
    private String nightLeader;
    /**
     * 夜班信息联络
     */
    private String nightContact;
    /**
     * 夜班物料准备
     */
    private String nightMateriel;
    /**
     * 夜班其他人员
     */
    private String nightOther;

    /**
     * 排班计划
     */
    private List<SchedulePlan> schedulePlanList;

    public Schedule() {
    }

    public Schedule(int id) {
        this.setId(id);
    }

}
