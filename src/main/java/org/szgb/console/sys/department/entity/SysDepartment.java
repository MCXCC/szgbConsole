package org.szgb.console.sys.department.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDepartment extends BeanEntity<SysDepartment> {
    private String name;
    private SysDepartment parent;

    public SysDepartment() {
    }
}
