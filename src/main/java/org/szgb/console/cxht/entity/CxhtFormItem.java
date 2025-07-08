package org.szgb.console.cxht.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class CxhtFormItem extends BeanEntity<CxhtFormItem> {
    @Serial
    private static final long serialVersionUID = 1L;

    private CxhtForm cxhtForm;
    private String loop;
    private String startPart;
    private String startNumber;
    private String endPart;
    private String endNumber;
}
