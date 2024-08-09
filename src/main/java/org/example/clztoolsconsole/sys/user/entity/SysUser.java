package org.example.clztoolsconsole.sys.user.entity;

import lombok.Data;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;

@Data
public class SysUser extends BeanEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String token;

    public SysUser(String token) {
        this.token = token;
    }
}
