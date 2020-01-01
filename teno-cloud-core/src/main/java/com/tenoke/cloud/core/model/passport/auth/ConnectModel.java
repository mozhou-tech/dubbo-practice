package com.tenoke.cloud.core.model.passport.auth;

import com.alibaba.fastjson.JSON;
import com.tenoke.cloud.core.enums.UserConnectProviderEnum;
import lombok.Data;

/**
 * @author jerrylau
 */
@Data
public class ConnectModel {

    private UserConnectProviderEnum providerId;

    private String providerUserId;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
