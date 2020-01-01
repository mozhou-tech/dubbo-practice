package com.tenoke.cloud.core.model.passport;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class PermissionCreateModel {

    private Long id;

    @Pattern(regexp = "URL|MENU|API|ELEMENT", message = "不支持的权限类别，请使用URL,MENU,API,ELEMENT")
    private String type;

    @NotBlank(message = "权限名称不能为空")
    private String name;

    @NotBlank(message = "权限指令不能为空")
    private String permission;

    private String url;

    private String description;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
