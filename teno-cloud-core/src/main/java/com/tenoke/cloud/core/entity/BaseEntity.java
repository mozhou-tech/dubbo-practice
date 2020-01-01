package com.tenoke.cloud.core.entity;
import com.alibaba.fastjson.JSON;

/**
 * @author jerrylau
 */
public class BaseEntity {

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}
