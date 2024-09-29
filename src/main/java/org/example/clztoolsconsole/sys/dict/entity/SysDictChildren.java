package org.example.clztoolsconsole.sys.dict.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictChildren extends BeanEntity <SysDictChildren> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysDict dict;
    private String label;
    private String value;
}
