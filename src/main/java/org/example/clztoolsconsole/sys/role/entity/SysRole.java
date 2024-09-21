package org.example.clztoolsconsole.sys.role.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRole extends BeanEntity<SysRole> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;

    public SysRole() {}
}

