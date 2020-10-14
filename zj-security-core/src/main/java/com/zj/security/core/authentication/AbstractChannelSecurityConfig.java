package com.zj.security.core.authentication;

import com.zj.security.core.properties.ImoocSecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 * @author zj
 * @describe
 * @date 2020 2020/10/14 14:32
 */
public class AbstractChannelSecurityConfig   extends WebSecurityConfigurerAdapter {
    @Autowired
    protected AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 配置了表单登录
     * loginPage
     * loginProcessingUrl
     * successHandler
     * failureHandler
     *
     * @param http
     * @throws Exception
     */
    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(ImoocSecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(ImoocSecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);
    }

}
