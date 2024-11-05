package org.szgb.console.sys.line.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysLine extends BeanEntity<SysLine> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private List<SysLineLocation> lineLocationList;
}
