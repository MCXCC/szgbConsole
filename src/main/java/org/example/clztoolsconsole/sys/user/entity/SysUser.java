package org.example.clztoolsconsole.sys.user.entity;

import lombok.Data;
import org.example.clztoolsconsole.utils.BeanEntity;

import java.io.Serial;
import java.util.Date;

@Data
public class SysUser extends BeanEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String token;

    public SysUser() {
    }

    public SysUser(String token) {
        this.token = token;
    }

    public SysUser(Integer id, String username, String password, Date createdAt,
                   Date updatedAt, Boolean isDeleted, Integer version, Integer createById, Integer UpdatedById, Integer sortOrder) {
        this.setId(id);
        this.username = username;
        this.password = password;
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
        this.setIsDeleted(isDeleted);
        this.setVersion(version);
        this.getCreatedBy().setId(createById);
        this.getUpdatedBy().setId(UpdatedById);
        this.setSortOrder(sortOrder);
    }
}
