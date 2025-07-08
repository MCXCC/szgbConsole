package org.szgb.core.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.szgb.console.sys.user.entity.SysUser;
import org.springframework.format.annotation.DateTimeFormat;
import org.szgb.console.utils.Page;

import java.io.Serializable;
import java.util.Date;

@Data
public class BeanEntity<T> implements Serializable {
    private String id;
    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    @JsonIgnore
    private Boolean isDeleted;

    private Integer version;
    @JsonIgnore
    private SysUser createdBy;
    @JsonIgnore
    private SysUser updatedBy;

    private Integer sortOrder;
    @JsonIgnore
    private Page<T> page;
}
