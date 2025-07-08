package org.szgb.console.cxht.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class CxhtLocationFormItem extends BeanEntity<CxhtLocationFormItem> {
    @Serial
    private static final long serialVersionUID = 1L;
    private CxhtForm cxhtForm;
    private CxhtFormItem cxhtFormItem;
    private int isRight;
    private String remark;
}
