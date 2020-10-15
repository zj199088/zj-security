package com.zj.security.browser.config;

import com.zj.security.core.authentication.AbstractChannelSecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author zj
 * @describe
 * @date 2020 2020/10/15 16:16
 */
@Component
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
