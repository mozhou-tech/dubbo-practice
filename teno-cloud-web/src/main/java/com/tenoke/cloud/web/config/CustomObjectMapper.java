package com.tenoke.cloud.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Configuration;

/**
 * @author jerrylau
 */
@Configuration
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        super();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, new ToStringSerializer());
        simpleModule.addSerializer(Long.class, new ToStringSerializer());
        registerModule(simpleModule);
    }
}
