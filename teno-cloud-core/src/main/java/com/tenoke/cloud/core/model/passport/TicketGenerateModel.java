package com.tenoke.cloud.core.model.passport;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class TicketGenerateModel {

    @NotNull
    private Integer vipType;

    private Integer second;

    @NotBlank
    @Length(max = 200, min = 5, message = "请输入5-200个字符")
    private String reason;

    @NotBlank
    @Length(max = 100, min = 3, message = "batch code length : 3-100")
    private String batchCode;

    @Max(value = 300, message = "单次不超过300个")
    @Min(value = 1, message = "单次至少生成一张")
    private Integer count;

    private Date expiredAt;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
