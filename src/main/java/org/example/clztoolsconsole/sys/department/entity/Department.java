package org.example.clztoolsconsole.sys.department.entity;

import lombok.Data;
import org.example.clztoolsconsole.utils.BeanEntity;

@Data
public class Department extends BeanEntity {
    private String name;
    private Department parent;
}
