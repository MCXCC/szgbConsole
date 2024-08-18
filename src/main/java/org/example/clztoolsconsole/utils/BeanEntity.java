package org.example.clztoolsconsole.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class BeanEntity implements Serializable {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date updatedAt;

    private Boolean isDeleted;

    private Integer version;

    private SysUser createdBy;

    private SysUser updatedBy;

    private Integer sortOrder;

    public BeanEntity() {
    }
}
