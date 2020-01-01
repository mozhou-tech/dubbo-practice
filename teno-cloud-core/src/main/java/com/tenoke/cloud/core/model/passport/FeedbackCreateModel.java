package com.tenoke.cloud.core.model.passport;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author liuyuancheng
 */
@Data
@NoArgsConstructor
public class FeedbackCreateModel {

    @NotBlank
    private String type;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Integer mark;

    private String reply;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
