package com.tenoke.cloud.core.enums;

/**
 * @author liuyuancheng
 */
public enum HttpResponseCodeEnum {


    // 成功
    SUCCESS(0),
    // 未知错误
    ERR_UNKNOWN(-1),
    // 密码不能为空
    ERR_PASSWORD_CANNOT_BE_EMPTY(-2),
    // 用户名不能为空
    ERR_USERNAME_CANNOT_BE_EMPTY(-3),
    // 操作失败
    ERR_ACTION_FAILED(-4),
    // 数据重复
    ERR_DUPLICATE_DATA(-5),
    // 数据验证不通过
    ERR_DATA_VALIDATE_FAILED(-6),
    // 网页没找到
    ERR_PAGE_NOT_FOUND(-7),
    // 服务器内部
    ERR_INTERNAL_SERVER_ERROR(-8),
    ;

    private Integer code;

    HttpResponseCodeEnum(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
