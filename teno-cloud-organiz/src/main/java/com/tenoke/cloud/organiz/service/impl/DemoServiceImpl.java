package com.tenoke.cloud.organiz.service.impl;

import com.tenoke.cloud.organiz.service.api.DemoService;
import org.apache.dubbo.config.annotation.Service;

@org.springframework.stereotype.Service
@Service(version = "v1")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot with dubbo-2.7.1)";
    }

}
