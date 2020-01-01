package com.tenoke.cloud.web.config.auth.connect;

import com.tenoke.cloud.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author jerrylau
 */
@Component
public class ConnectSecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private ConnectLoginSuccessHandler connectLoginSuccessHandler;

    @Autowired
    private UserService userService;

    @Override
    public void configure(HttpSecurity http) {
        ConnectAuthenticationFilter connectAuthenticationFilter = new ConnectAuthenticationFilter();
        connectAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        connectAuthenticationFilter.setAuthenticationSuccessHandler(connectLoginSuccessHandler);

        ConnectAuthenticationProvider connectAuthenticationProvider = new ConnectAuthenticationProvider();
        connectAuthenticationProvider.setUserService(userService);
        http.authenticationProvider(connectAuthenticationProvider)
                .addFilterAfter(connectAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}