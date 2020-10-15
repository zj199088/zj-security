package com.zj.security.core.properties;

/**
 * 短信验证码属性
 * @author zj
 */
public class SmsCodeProperties {
    /**
     * 短信验证码长度默认6
     */
    private int length = 6;
    /**
     * 默认60秒
     */
    private int expireIn = 60;
    /**
     * 多个url时用逗号隔开
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
