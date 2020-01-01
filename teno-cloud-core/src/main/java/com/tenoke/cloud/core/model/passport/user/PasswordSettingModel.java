package com.tenoke.cloud.core.model.passport.user;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordSettingModel {

    @NotNull(message = "userId不能为空")
    private Long userId;

    private String oldPassword;

    @NotEmpty(message = "请填写新密码")
    @Length(min = 6, message = "新密码长度少于6位")
    private String newPassword;

    @NotEmpty(message = "请再次填写新密码")
    private String repeatNewPassword;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
