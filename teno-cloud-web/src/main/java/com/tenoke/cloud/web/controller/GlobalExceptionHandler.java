package com.tenoke.cloud.web.controller;

import com.tenoke.cloud.core.domain.HttpResponseObj;
import com.tenoke.cloud.core.enums.HttpResponseCodeEnum;
import com.tenoke.cloud.core.utils.HttpResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

/**
 * @author liuyuancheng
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 404错误
     *
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public HttpResponseObj requestHandlingNoHandlerFound() {
        return HttpResponseUtil.error( "页面没找到", "");
    }

    /**
     * 处理500错误
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public HttpResponseObj requestHandlingInternalServerError(Exception ex) {
        String errorMsg = ex.getMessage() != null ? ex.getMessage() : "Unknown error.";
        String errorTrace = Arrays.toString(ex.getStackTrace());
        log.error(String.format("%s:%s", errorMsg, errorTrace));
        return HttpResponseUtil.error(errorMsg, errorTrace);
    }

}
