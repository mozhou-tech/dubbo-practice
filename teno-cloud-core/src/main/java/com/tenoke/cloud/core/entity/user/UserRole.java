package com.tenoke.cloud.core.entity.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author jerrylau
 */
@Data
@Entity(name = "user_roles")
public class UserRole implements Serializable {

    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
