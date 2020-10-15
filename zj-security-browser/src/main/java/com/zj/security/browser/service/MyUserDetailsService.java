package com.zj.security.browser.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zj
 * @describe
 * @date 2020 2020/10/15 16:27
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String password = passwordEncoder.encode("123456");
        return new User(username,password, true , true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
