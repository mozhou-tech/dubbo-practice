package com.tenoke.cloud.core.model.passport;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author jerrylau
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFavorPageModel {

    private Long userId;

    @NotNull(message = "page id cannot be null.")
    private Long pageId;

    @NotBlank(message = "Unsupported action.")
    private String action;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
