package com.zj.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 加载自定义的加密器
 * @author zj
 * @describe
 * @date 2020 2020/10/14 14:41
 */
@Component
public class PasswordConfig {
    @Bean
    public  PasswordEncoder passwordEncoder() {
        return  new MyPasswordEncoder();
    }
}
