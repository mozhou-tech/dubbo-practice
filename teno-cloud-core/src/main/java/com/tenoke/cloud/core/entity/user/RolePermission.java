package com.tenoke.cloud.core.entity.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author jerrylau
 */
@Data
@Entity(name = "role_permissions")
@NoArgsConstructor
public class RolePermission implements Serializable {

    @Id
    private Long id;

    @Column(name = "permission_id")
    private Long permissionId;

    @Column(name = "role_id")
    private Long roleId;

    public RolePermission(Long roleId, Long permissionId){
        this.setPermissionId(permissionId);
        this.setRoleId(roleId);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
