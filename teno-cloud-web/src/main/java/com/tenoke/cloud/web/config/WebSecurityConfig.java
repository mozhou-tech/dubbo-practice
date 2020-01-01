package com.tenoke.cloud.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jerrylau
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    @Order(-1)
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/hello").permitAll()
                .antMatchers("/websocket/**").permitAll()
                .antMatchers("/oauth/connect").permitAll()
                .antMatchers("/oauth/connect/weixin/login/redirect").permitAll()
                .antMatchers("/pages/page/**").permitAll()
                .antMatchers("/pages/explore/widgets").permitAll()
                .antMatchers("/pages/fastfocus").permitAll()
                .antMatchers("/pages/explore/widgets-id").permitAll()
                .antMatchers("/v2/api-docs/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/tokens/**").permitAll()
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/bot/explore/rank").permitAll()
                .antMatchers("/captcha").permitAll()
                .antMatchers("/passport/user/pre-login").permitAll()
                .antMatchers("/pages/page/public-id").permitAll()
//                .antMatchers("/user/**").authenticated()
//                .and().formLogin().permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();
//		 @formatter:on
    }

}
