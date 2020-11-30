package com.mj.time.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mj.time.domain.User;
import lombok.Data;

@Data
public class AuthUserDto {
    /**
     * 授权类型：0--WEB端 1--微信端
     */
    private String authType;

    private String userName;

    @JsonIgnore
    private String password;

    //**********************************
    //以下为微信类传输字段

    //临时登录凭证
    private String code;

    //微信openId
    private String openId;

    //微信用户非敏感信息
    private String rawData;

    //微信用户签名
    private String signature;

    //微信用户敏感信息
    private String encryptedData;

    //微信用户解密算法的向量
    private String iv;

    /**
     * 会话密钥
     */
    @JsonIgnore
    private String sessionKey;

    /**
     * 用户在开放平台的唯一标识符
     */
    @JsonIgnore
    private String unionId;

    //以上为微信类传输字段
    //**********************************

    //服务器jwt token
    private String token;

    //value = "用户信息
    private User userInfo;
}
