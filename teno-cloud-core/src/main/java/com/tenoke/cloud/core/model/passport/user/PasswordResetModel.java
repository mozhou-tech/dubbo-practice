package com.tenoke.cloud.core.model.passport.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class PasswordResetModel {

    private Long userId;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String rePassword;

    @NotBlank
    private String tokenCode;


    public PasswordResetModel(Long userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
