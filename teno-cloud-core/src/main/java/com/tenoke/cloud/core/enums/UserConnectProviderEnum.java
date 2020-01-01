package com.tenoke.cloud.core.enums;

/**
 * @author jerrylau
 */

public enum UserConnectProviderEnum {


    /**
     * 微信
     */
    WEIXIN("WEIXIN"),

    /**
     * 邮件
     */
    EMAIL("EMAIL"),

    /**
     * 手机号
     */
    PHONE("PHONE");

    private String value;

    UserConnectProviderEnum(String value) {
        this.value = value;
    }

}
