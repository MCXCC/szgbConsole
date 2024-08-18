package org.example.clztoolsconsole.sys.department.entity;

import lombok.Data;
import org.example.clztoolsconsole.utils.BeanEntity;

@Data
public class SysDepartment extends BeanEntity {
    private String name;
    private SysDepartment parent;

    public SysDepartment() {
        super();
    }
}
