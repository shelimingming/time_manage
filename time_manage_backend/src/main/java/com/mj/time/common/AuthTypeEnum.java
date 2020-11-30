package com.mj.time.common;

/**
 * 登陆类型
 */
public enum AuthTypeEnum {
    PASSWORD("用户名密码登陆", "0"),
    WECHAT("微信登陆", "1");

    private String name;
    private String value;

    private AuthTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
