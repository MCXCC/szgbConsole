package org.szgb.console.sys.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.szgb.console.sys.department.entity.SysDepartment;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BeanEntity<SysUser> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String no;
    private String name;
    private String phone;
    private String password;
    private String token;
    private SysDepartment department;
    private Integer scheduleDayCount;
    private Integer scheduleNightCount;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scheduleLastDay;

    public SysUser() {
    }

    public SysUser(int id) {
        this.setId(id);
    }
}
