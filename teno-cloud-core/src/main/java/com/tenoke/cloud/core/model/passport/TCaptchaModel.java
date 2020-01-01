package com.tenoke.cloud.core.model.passport;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerrylau
 */
@Data
@NoArgsConstructor
public class TCaptchaModel {

    /**
     *
     */
    private String aid;

    /**
     * https://007.qq.com/captcha/#/gettingStart
     */
    private String AppSecretKey;

    /**
     * 验证码客户端验证回调的票据
     */
    private String Ticket;

    /**
     * 验证码客户端验证回调的随机串
     */
    private String Randstr;

    /**
     * 提交验证的用户的IP地址（eg: 10.127.10.2）
     */
    private String UserIP;
}
