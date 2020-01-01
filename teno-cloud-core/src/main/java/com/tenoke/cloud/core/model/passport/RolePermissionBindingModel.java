package com.tenoke.cloud.core.model.passport;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class RolePermissionBindingModel {

    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    @NotNull(message = "权限ID不能为空")
    private Long permissionId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
