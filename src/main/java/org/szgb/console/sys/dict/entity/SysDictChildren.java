package org.szgb.console.sys.dict.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictChildren extends BeanEntity <SysDictChildren> {
    @Serial
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private SysDict dict;
    private String label;
    private String value;
}
