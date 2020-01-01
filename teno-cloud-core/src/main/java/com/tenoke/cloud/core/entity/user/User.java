package com.tenoke.cloud.core.entity.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author jerrylau
 */
@Getter
@Setter
@Entity(name = "users")
@NoArgsConstructor
@JsonIgnoreProperties(value= {"roles","userConnects"})
public class User implements Serializable, UserDetails, CredentialsContainer {

    private static final long serialVersionUID = 7472439018990648182L;

    @Id
    private Long id;

    @Column(updatable = false, insertable = false, nullable = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String username;

    private String nickname;

    @Column(updatable = false,nullable = false)
    private String password;

    @Column(columnDefinition = "tinyint(1) DEFAULT 2 COMMENT '0女，1男，2未知'",nullable = false)
    private Integer gender;

    private Long qq;

    @Column(columnDefinition = "tinyint(1) DEFAULT 1 COMMENT '用户是否是可用状态, 1可用0禁用'")
    private Boolean enabled;

    @Column(nullable = true)
    private String email;

    @Column(columnDefinition = "varchar(200) DEFAULT '' COMMENT '头像地址'")
    private String avatar;

    private String province;

    private Date lastChangeNameAt;

    private Date lastLoginAt;

    @Column(updatable = false,insertable = true)
    private Date createdAt;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * 用户设置
     */
    @Transient
    private Map<String, String> settings;

    @Transient
    private Set<String> roleCodes;

    @Transient
    private Set<String> permissionCodes;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))},
            inverseJoinColumns = {@JoinColumn(name = "role_id",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))})
    @JSONField(serialize = false)
    private List<Role> roles;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "userId")
    @JSONField(serialize = false)
    private Set<UserConnect> userConnects;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void eraseCredentials() {

    }

    public User(Long id, String phone, String username, Boolean enabled, String email, String avatar, Integer gender) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.enabled = enabled;
        this.email = email;
        this.avatar = avatar;
        this.gender = gender;
    }
}