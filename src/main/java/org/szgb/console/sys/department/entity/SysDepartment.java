package org.szgb.console.sys.department.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDepartment extends BeanEntity<SysDepartment> {
    private String name;
    private SysDepartment parent;
    private ArrayList<SysDepartment> children;

    public SysDepartment() {
    }

    public SysDepartment(int id) {
        this.setId(id);
    }
}
