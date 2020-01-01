package com.tenoke.cloud.core.entity.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jerrylau
 */
@Entity(name = "user_setting")
@Data
public class UserSetting implements Serializable {
    @Id
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 属性名
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 属性值
     */
    @Column(name = "`value`")
    private String value;

    /**
     * 过期时间
     */
    private Date expiredAt;

    /**
     * 生效时间
     */
    private Date takeEffectAt;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
