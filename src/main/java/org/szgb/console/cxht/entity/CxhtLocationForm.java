package org.szgb.console.cxht.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.console.sys.line.entity.SysLineLocation;
import org.szgb.console.sys.line.entity.SysLineLocationEquipment;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class CxhtLocationForm extends BeanEntity<CxhtLocationForm> {
    @Serial
    private static final long serialVersionUID = 1L;

    private SysLineLocation lineLocation;
    private CxhtForm cxhtForm;
    private SysLineLocationEquipment equipment;
    private int performance;
    private int isArchive;
    private ArrayList<CxhtLocationFormItem> cxhtLocationFormItemList;
}
