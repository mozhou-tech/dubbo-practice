package com.tenoke.cloud.core.entity.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuyuancheng
 */
@Data
@Entity(name = "roles")
public class Role implements Serializable {

    @Id
    private Long id;

    private String name;

    private String code;

    private String remark;

    private Integer status;

    private Long parentId;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
            joinColumns = {@JoinColumn(name = "role_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))},
            inverseJoinColumns = {@JoinColumn(name = "permission_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))})
    private List<Permission> permissions;

    private Date createdAt;

    private Date updatedAt;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}