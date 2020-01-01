package com.tenoke.cloud.core.model.passport;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author jerrylau
 */
@Data
public class RoleEditModel {

    private Long id;

    @NotBlank(message = "角色指令不能为空")
    private String code;

    @NotBlank(message = "角色名不能为空")
    private String name;

    private String remark;

    @Min(value = 0)
    @Max(value = 1)
    private Integer status;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
