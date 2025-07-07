package org.szgb.console.sys.equipment.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.line.entity.SysLine;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysEquipment extends BeanEntity<SysEquipment> {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 使用线路
     */
    private SysLine line;
    /**
     * 设备类型（所属系统）
     */
    private int type;
    /**
     * 设备厂商
     */
    private String manufacturer;
    /**
     * 名字
     */
    private String name;
}
