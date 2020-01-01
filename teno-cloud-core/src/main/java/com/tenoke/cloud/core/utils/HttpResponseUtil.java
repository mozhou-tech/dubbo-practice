package com.tenoke.cloud.core.utils;

import com.tenoke.cloud.core.domain.HttpResponseObj;
import org.apache.http.HttpStatus;

import java.util.HashMap;


/**
 * @author liuyuancheng
 */
public class HttpResponseUtil {

    static final private int HTTP_BODY_DESCRIPTION_CODE_SUCCESS = 0;
    static final private int HTTP_BODY_DESCRIPTION_CODE_FAILED = -1;

    private static HttpResponseObj httpResponseObj = new HttpResponseObj();


    public static HttpResponseObj success(Object data, String message) {
        httpResponseObj.setCode(HTTP_BODY_DESCRIPTION_CODE_SUCCESS);
        httpResponseObj.setData(data);
        return httpResponseObj;
    }

    public static HttpResponseObj success() {
        return success(null, "OK");
    }

    public static HttpResponseObj success(Object data) {
        return success(data, "OK");
    }

    public static HttpResponseObj error(String message, String trace) {
        httpResponseObj.setCode(HTTP_BODY_DESCRIPTION_CODE_FAILED);
        httpResponseObj.setData(message);
        httpResponseObj.setTrace(trace);
        return httpResponseObj;
    }
}
