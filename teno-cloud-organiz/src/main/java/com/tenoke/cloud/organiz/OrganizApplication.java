package com.tenoke.cloud.organiz;

import com.deepoove.swagger.dubbo.annotations.EnableDubboSwagger;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfig
@SpringBootApplication
@EnableDubboSwagger
public class OrganizApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizApplication.class, args);
    }

}
