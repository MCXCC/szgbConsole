package org.example.clztoolsconsole.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.sys.department.entity.SysDepartment;
import org.example.clztoolsconsole.utils.BeanEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Schedule extends BeanEntity<Schedule> {
    private SysDepartment department;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String M800;
    private String dayGaffer;
    private String dayLeader;
    private String dayContact;
    private String dayMateriel;
    private String dayOther;
    private String nightGaffer;
    private String nightLeader;
    private String nightContact;
    private String nightMateriel;
    private String nightOther;

}
