package org.szgb.console.sys.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.role.entity.SysRole;
import org.szgb.console.utils.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserRole extends BeanEntity<SysUserRole> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysUser user;
    private SysRole role;
}
