package org.szgb.console.sys.line.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysLineLocation extends BeanEntity<SysLineLocation> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysLine line;
    private int type;
    private String name;
}
