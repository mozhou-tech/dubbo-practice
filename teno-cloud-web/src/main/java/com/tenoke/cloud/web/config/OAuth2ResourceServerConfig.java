package com.tenoke.cloud.web.config;

import com.tenoke.cloud.web.config.auth.connect.ConnectSecurityConfigurer;
import com.tenoke.cloud.web.config.auth.mobile.MobileSecurityConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author jerrylau
 */
@EnableResourceServer
@Configuration
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private MobileSecurityConfigurer mobileSecurityConfigurer;

    @Autowired
    private ConnectSecurityConfigurer connectSecurityConfigurer;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/oauth/**").permitAll()
                .antMatchers("/oauth/connect").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/websocket/**").permitAll()
                .antMatchers("/hello").permitAll()
                .antMatchers("/captcha").permitAll()
                /**
                 * pages
                 */
                .antMatchers(
                        "/",
                        "/pages/favicon/**",
                        "/pages/page/*/full-page-data",
                        "/pages/explore/**",
                        "/pages/fastfocus"
                ).permitAll()
                /**
                 * bot
                 */
                .antMatchers(
                        "/bot/news/**",
                        "/bot/explore/rank"
                ).permitAll()
                /**
                 * passport
                 */
                .antMatchers("/passport/user/pre-login",
                        "/passport/user/me",
                        "/passport/user/register",
                        "/passport/oauth/**",
                        "/password-reset/send-mail-token",
                        "/password-reset/set-new"
                ).permitAll()
                /**
                 * 其它
                 */
//                .antMatchers("/oauth/connect/weixin/login/redirect").permitAll()
//                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/common/**").permitAll()
                .antMatchers("/swagger-ui.html/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/api-docs/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/pages/page/public-id").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();
        http.apply(mobileSecurityConfigurer);
        http.apply(connectSecurityConfigurer);
    }

}
