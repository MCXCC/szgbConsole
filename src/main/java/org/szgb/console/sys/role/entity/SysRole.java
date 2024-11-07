package org.szgb.console.sys.role.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRole extends BeanEntity<SysRole> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String menus;

    public SysRole() {
    }

    public SysRole(int id) {
        this.setId(id);
    }
}

