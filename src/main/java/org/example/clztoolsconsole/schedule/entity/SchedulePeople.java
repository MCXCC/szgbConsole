package org.example.clztoolsconsole.schedule.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;


@EqualsAndHashCode(callSuper = true)
@Data
public class SchedulePeople extends BeanEntity<SchedulePeople> {
    @Serial
    private static final long serialVersionUID = 1L;
    private SchedulePlan schedulePlan;
    private SysUser user;
    private int type;
}
