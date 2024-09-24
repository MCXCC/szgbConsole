package org.example.clztoolsconsole.user_certification.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.certification.entity.Certification;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserCertification extends BeanEntity<UserCertification> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysUser user;
    private Certification certification;
    private Date gotAt;
    private Date expiredAt;
}
