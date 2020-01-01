package com.tenoke.cloud.pacs.service;

import org.springframework.stereotype.Service;

@Service
public class JNIDemoService {

    public native static String hello();
    static {
        System.load("/Users/jerrylau/IdeaProjects/teno-cloud/teno-cloud-pacs/src/main/resources/jni/demo-cpython-36m-darwin.so");
    }

    public void printHello(){

    }
}
