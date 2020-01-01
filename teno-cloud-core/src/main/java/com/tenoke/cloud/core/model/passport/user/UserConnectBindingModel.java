package com.tenoke.cloud.core.model.passport.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class UserConnectBindingModel {

    @NotNull(message = "userId不能为Null")
    private Long userId;

    @NotEmpty(message = "手机号码不能为空")
    private String phone;

    /**
     * 验证码uuid
     */
    private String captchaUuid;

    /**
     * 用户输入的验证码值
     */
    private String captchaValue;

    private String username;

    @Email
    private String email;

    private String verifyCode;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
