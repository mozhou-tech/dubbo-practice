package com.tenoke.cloud.web.config.auth.connect;

import com.alibaba.fastjson.JSONObject;
import com.tenoke.cloud.core.model.passport.auth.ConnectModel;
import com.tenoke.cloud.web.service.UserService;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author jerrylau
 */
public class ConnectAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ConnectAuthenticationToken connectAuthenticationToken1 = (ConnectAuthenticationToken) authentication;
        // 获取登录信息，并解析出来
        ConnectModel connectModel = JSONObject.parseObject((String) connectAuthenticationToken1.getPrincipal(), ConnectModel.class);
        UserDetails userDetails = userService.loadUserByProviderUserId(connectModel.getProviderId().toString(), connectModel.getProviderUserId());

        if (userDetails == null) {
            throw new InternalAuthenticationServiceException("改用户未绑定社交账号:" + connectAuthenticationToken1.getPrincipal());
        }

        ConnectAuthenticationToken connectAuthenticationToken = new ConnectAuthenticationToken(userDetails, userDetails.getAuthorities());
        connectAuthenticationToken.setDetails(connectAuthenticationToken1.getDetails());
        return connectAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ConnectAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
