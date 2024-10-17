package org.example.clztoolsconsole.sys.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.certification.entity.Certification;
import org.example.clztoolsconsole.utils.BeanEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserCertification extends BeanEntity<SysUserCertification> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysUser user;
    private Certification certification;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gotAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expiredAt;
}
