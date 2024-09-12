package org.example.clztoolsconsole.material.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class Material extends BeanEntity {
    @Serial
    private static final long serialVersionUID=1L;

    private String workshop;
    private String gang;
    private String name;
    private String specification;
    private Integer number;
    private Integer pictureId;
    private String remark;
}
