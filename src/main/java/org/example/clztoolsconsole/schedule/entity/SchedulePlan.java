package org.example.clztoolsconsole.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.utils.BeanEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SchedulePlan extends BeanEntity<SchedulePlan> {
    @Serial
    private static final long serialVersionUID = 1L;
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
    private String scheduleType;
    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startAt;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    private List<SchedulePeople> schedulePeopleList;
}
