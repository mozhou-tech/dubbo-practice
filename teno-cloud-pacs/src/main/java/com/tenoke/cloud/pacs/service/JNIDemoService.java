package com.tenoke.cloud.pacs.service;

import org.springframework.stereotype.Service;

@Service
public class JNIDemoService {

    public native static String hello();

    static {
        System.loadLibrary("/Users/jerrylau/IdeaProjects/teno-cloud/teno-cloud-pacs/src/main/resources/jni/demo-cpython-36m-darwin.so");
    }

    void printHello() {
        hello();
    }
}
