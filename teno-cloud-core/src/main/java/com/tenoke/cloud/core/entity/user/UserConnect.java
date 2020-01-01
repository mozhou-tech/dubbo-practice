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
@Data
@Entity(name = "user_connect")
public class UserConnect implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String openid;

    private String unionid;

    private String headimgurl;

    private String city;

    private String province;

    private String language;

    private Integer sex;

    private Date createdAt;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
