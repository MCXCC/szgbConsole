package org.szgb.console.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SchedulePlan extends BeanEntity<SchedulePlan> {
    @Serial
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private Schedule schedule;
    /**
     * 任务类型
     */
    private int taskType;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 地点
     */
    private String location;
    /**
     * 班次类型
     */
    private int scheduleType;
    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startAt;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endAt;
    /**
     * 目标
     */
    private String goal;
    /**
     * 备注
     */
    private String remark;

    private List<SchedulePlanPeople> schedulePeopleList;

    public SchedulePlan() {
    }

    public SchedulePlan(int id) {
        this.setId(id);
    }
}
