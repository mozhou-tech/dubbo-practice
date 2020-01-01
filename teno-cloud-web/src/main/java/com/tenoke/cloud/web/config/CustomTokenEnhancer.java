package com.tenoke.cloud.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jerrylau
 */
@Slf4j
@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    /**
     * JWT附加额外payload
     *
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        PermissionService permissionService = ContextUtil.getBean("permissionService");
//
//        UserSettingService userSettingService = ContextUtil.getBean("userSettingService");
//
//        RoleService roleService = ContextUtil.getBean("roleService");
//
//        UserQuotaService userQuotaService = ContextUtil.getBean("userQuotaService");
//
//        User user = (User) authentication.getPrincipal();
        Map<String, Object> additionalInfo = new HashMap<>(1);
//        user.setSettings(userSettingService.getSettingMap(user.getId()));
//        user.setRoleCodes(roleService.getRoleCodesByUserId(user.getId()));
//        user.setPermissionCodes(permissionService.getPermissionCodesByUserId(user.getId()));
//        user.setUserQuota(userQuotaService.reCalcQuotaUsage(user.getId()));
//        user.setPassword(null);
//        additionalInfo.put("user", user);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
