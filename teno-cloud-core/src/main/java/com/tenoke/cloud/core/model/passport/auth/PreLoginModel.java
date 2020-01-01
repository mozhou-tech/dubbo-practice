package com.tenoke.cloud.core.model.passport.auth;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author liuyuancheng
 */
@Data
public class PreLoginModel {


    @NotEmpty(message = "请输入密码")
    private String password;

    @NotEmpty(message = "请输入用户名")
    private String username;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
