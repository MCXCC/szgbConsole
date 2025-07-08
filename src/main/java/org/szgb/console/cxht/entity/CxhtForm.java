package org.szgb.console.cxht.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.equipment.entity.SysEquipment;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class CxhtForm extends BeanEntity<CxhtForm> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SysEquipment equipment;
    private int edition;
    private ArrayList<CxhtFormItem> cxhtFormItemList;
}
