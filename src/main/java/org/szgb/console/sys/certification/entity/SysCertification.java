package org.szgb.console.sys.certification.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.szgb.core.base.entity.BeanEntity;

import java.io.Serial;


@EqualsAndHashCode(callSuper = true)
@Data
public class SysCertification extends BeanEntity<SysCertification> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int period;

    public SysCertification() {
    }

    public SysCertification(int id) {
        this.setId(id);
    }
}
