package org.szgb.core.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.szgb.console.sys.user.entity.SysUser;
import org.springframework.format.annotation.DateTimeFormat;
import org.szgb.console.utils.Page;

import java.io.Serializable;
import java.util.Date;

@Data
public class BeanEntity<T> implements Serializable {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    private Boolean isDeleted;

    private Integer version;

    private SysUser createdBy;

    private SysUser updatedBy;

    private Integer sortOrder;

    private Page<T> page;

    public BeanEntity() {
    }
}
