package org.szgb.console.sys.line.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.equipment.entity.SysEquipment;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysLineLocationEquipment extends BeanEntity<SysLineLocationEquipment> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysLineLocation lineLocation;
    private SysEquipment equipment;
    private String name;
}
