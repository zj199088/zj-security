package com.zj.security.core.properties;

/**
 * 浏览器属性
 *
 * @author zj
 */
public class BrowserProperties {
    private String loginPage = "/zj-signIn.html";

    private LoginResponseType loginType = LoginResponseType.JSON;

    private int rememberMeSeconds = 3600;

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }
}
