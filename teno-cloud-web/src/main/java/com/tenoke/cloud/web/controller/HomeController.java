package com.tenoke.cloud.web.controller;

import com.tenoke.cloud.core.domain.HttpResponseObj;
import com.tenoke.cloud.core.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jerrylau
 */
@RestController
@RequestMapping(path = "")
public class HomeController {

    @GetMapping(path = "hello")
    public HttpResponseObj hello(){
        return HttpResponseUtil.success("test","");
    }

}
