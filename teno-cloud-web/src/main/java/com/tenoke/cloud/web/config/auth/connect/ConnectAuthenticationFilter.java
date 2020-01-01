package com.tenoke.cloud.web.config.auth.connect;

import com.alibaba.fastjson.JSON;
import com.tenoke.cloud.core.model.passport.auth.ConnectModel;
import com.tenoke.cloud.core.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jerrylau
 */
@Slf4j
public class ConnectAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Setter
    @Getter
    private boolean postOnly = true;

    public ConnectAuthenticationFilter() {
        super(new AntPathRequestMatcher("/oauth/connect", HttpMethod.POST.toString()));
    }

    /**
     * 提供获取beyhub自身accesstoken的接口
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals(HttpMethod.POST.name())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        log.debug("尝试基于oauth/connect的认证");
        String connectHeader = request.getHeader("ConnectAuthorization");
        if (connectHeader == null) {
            throw new RuntimeException("ConnectAuthorization error.");
        }
        ConnectModel connectModel = JSON.parseObject(StringUtil.base64Decode(connectHeader), ConnectModel.class);
        ConnectAuthenticationToken connectAuthenticationToken = new ConnectAuthenticationToken(connectModel);

        setDetails(request, connectAuthenticationToken);

        return this.getAuthenticationManager().authenticate(connectAuthenticationToken);
    }

    protected void setDetails(HttpServletRequest request, ConnectAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
