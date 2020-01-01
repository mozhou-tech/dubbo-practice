package com.tenoke.cloud.core.domain;

import com.alibaba.fastjson.JSON;
import com.tenoke.cloud.core.enums.HttpResponseCodeEnum;
import lombok.Data;
import lombok.Setter;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Http 返回对象
 *
 * @author liuyuancheng
 */
@Data
public class HttpResponseObj {

    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String message;

    /**
     * 具体的内容.
     */
    private Object data;

    private String trace;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
