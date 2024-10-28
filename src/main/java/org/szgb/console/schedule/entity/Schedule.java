package org.szgb.console.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.console.utils.BeanEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Schedule extends BeanEntity<Schedule> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysDepartment department;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
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
}
