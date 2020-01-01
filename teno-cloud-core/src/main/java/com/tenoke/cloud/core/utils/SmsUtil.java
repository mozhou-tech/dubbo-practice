package com.tenoke.cloud.core.utils;

import com.alibaba.fastjson.JSONPath;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.tenoke.cloud.core.constants.AliyunAccessKey;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author jerrylau
 */
@Component
@Slf4j
public class SmsUtil {

    public static void sendVerifyCodeAliyun(@NonNull String phoneNumber, @NonNull String code) {
        if (!ValidatorUtil.isPhoneNumber(phoneNumber)) {
            throw new RuntimeException("接收验证码的手机号码有误：" + phoneNumber);
        }
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", AliyunAccessKey.ALIYUN_ACCESS_KEY_ID, AliyunAccessKey.ALIYUN_ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "beyhub");
        request.putQueryParameter("TemplateCode", "SMS_173346530");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            if (!"OK".equals(JSONPath.read(response.getData(), "$.Code").toString())) {
                log.warn("sendVerifyCodeAliyun : " + response.getData());
                throw new RuntimeException("发送验证码失败：" + response.getData());
            }
        } catch (ClientException e) {
            e.printStackTrace();
            log.trace(e.toString());
            throw new RuntimeException("发送验证码失败：" + e.getMessage());
        }
    }

}
