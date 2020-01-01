package com.tenoke.cloud.pacs.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JNIDemoServiceTest {

    @Autowired
    private JNIDemoService jniDemoService;

    @Test
    void printHello() {
        jniDemoService.printHello();
    }
}