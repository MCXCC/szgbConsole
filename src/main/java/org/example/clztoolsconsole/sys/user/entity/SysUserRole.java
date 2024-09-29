package org.example.clztoolsconsole.sys.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.sys.role.entity.SysRole;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserRole extends BeanEntity<SysUserRole> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysUser user;
    private SysRole role;
}
