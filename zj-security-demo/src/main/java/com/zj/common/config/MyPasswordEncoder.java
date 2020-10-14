package com.zj.common.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * TODO 自定义的加密器
 * @author zj
 * @describe
 * @date 2020 2020/10/14 14:40
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
