package com.tenoke.cloud.web.config.auth.mobile;

import com.tenoke.cloud.web.service.UserService;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author jerrylau
 */
public class MobileAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken mobileAuthenticationToken = (MobileAuthenticationToken) authentication;
        UserDetails userDetails = userService.loadUserByPhone((String) mobileAuthenticationToken.getPrincipal());

        if (userDetails == null) {
            throw new InternalAuthenticationServiceException("手机号不存在:" + mobileAuthenticationToken.getPrincipal());
        }

        MobileAuthenticationToken authenticationToken = new MobileAuthenticationToken(userDetails, userDetails.getAuthorities());
        authenticationToken.setDetails(mobileAuthenticationToken.getDetails());
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
