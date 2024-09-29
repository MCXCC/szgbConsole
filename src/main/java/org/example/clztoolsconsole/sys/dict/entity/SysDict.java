package org.example.clztoolsconsole.sys.dict.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDict extends BeanEntity<SysDict> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private List<SysDictChildren> dictChildren;
}