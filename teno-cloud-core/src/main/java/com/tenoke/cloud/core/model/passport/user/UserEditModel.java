package com.tenoke.cloud.core.model.passport.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class UserEditModel {

    private Long userId;

    @Size(min = 4, max = 16, message = "用户名4-16个字符")
    private String username;

    @Email(message = "请填写正确的Email")
    private String email;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "[0-9A-Za-z]+", message = "密码应是字母、数字的组合")
    private String password;

    @NotBlank(message = "再次输入密码")
    private String rePassword;

    private Boolean enabled;

    private Integer gender;

    private String avatar;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
