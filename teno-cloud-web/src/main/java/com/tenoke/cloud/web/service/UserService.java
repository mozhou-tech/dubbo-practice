package com.tenoke.cloud.web.service;

import com.tenoke.cloud.core.entity.user.User;
import com.tenoke.cloud.core.entity.user.UserConnect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByPhone(String number) throws UsernameNotFoundException {
        return null;
    }

    public User loadUserByProviderUserId(String providerId, String providerUserId) {
        return null;
    }
}
