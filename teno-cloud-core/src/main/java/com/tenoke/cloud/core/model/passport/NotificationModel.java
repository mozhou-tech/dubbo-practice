package com.tenoke.cloud.core.model.passport;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class NotificationModel {

    private Long id;

    @NotEmpty(message = "title不能为空")
    private String title;

    @NotEmpty(message = "通知内容不能为空")
    private String text;

    @NotNull(message = "recId不能为null")
    private Long recId;

    @NotNull(message = "sendId不能为null")
    private Long sendId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
