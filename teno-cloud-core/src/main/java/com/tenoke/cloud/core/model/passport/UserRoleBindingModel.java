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
public class UserRoleBindingModel {

    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    @NotNull(message = "必须指定是绑定关系还是解除关系")
    private Boolean binding;

    public UserRoleBindingModel(Long userId, Long roleId, Boolean binding) {
        this.userId = userId;
        this.roleId = roleId;
        this.binding = binding;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
