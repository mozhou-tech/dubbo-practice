package com.tenoke.cloud.core.entity.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyuancheng
 */
@Data
@Entity(name = "permissions")
public class Permission implements Serializable {

    @Id
    private Long id;

    private String type;

    private String name;

    private String permission;

    private String icon;

    private Integer sort;

    private String url;

    private String description;

    private Integer status;

    private Long parentId;

    private Date createdAt;

    private Date updatedAt;

    @Override
    public String toString() {
        return JSON.toJSONString(this);

    }

}
