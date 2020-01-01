package com.tenoke.cloud.core.model.passport.user;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class UseVipTicketModel {

    private Long userId;

    private String ticketCode;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
