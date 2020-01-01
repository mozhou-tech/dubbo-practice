package com.tenoke.cloud.core.model.passport.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserFavorPageModel {

    private Long userId;

    @NotNull(message = "Page id cannot be null.")
    private Long pageId;

    private Integer stars;

    @NotBlank(message = "Unsupported action.")
    private String action;

}
