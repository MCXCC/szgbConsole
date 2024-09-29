package org.example.clztoolsconsole.certification.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;


@EqualsAndHashCode(callSuper = true)
@Data
public class Certification extends BeanEntity<Certification> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int period;

    public Certification() {}
}
