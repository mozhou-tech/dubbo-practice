package com.tenoke.cloud.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @author jerrylau
 */
@Slf4j
@Component
public class ValidatorUtil {

    /**
     * 是否是手机号码
     *
     * @param input
     * @return
     */
    public static Boolean isPhoneNumber(String input){
        if(input == null || input.isEmpty()){
            return false;
        }
        return Pattern.matches("^(1[3-9])\\d{9}$", input);
    }
}
