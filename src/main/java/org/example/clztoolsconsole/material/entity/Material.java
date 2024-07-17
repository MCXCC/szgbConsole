package org.example.clztoolsconsole.material.entity;

import lombok.Data;
import org.example.clztoolsconsole.utils.BeanEntity;

@Data
public class Material extends BeanEntity {
    private String workshop;
    private String gang;
    private String name;
    private String specification;
    private int number;
    private int pictureId;
    private String remark;
}
