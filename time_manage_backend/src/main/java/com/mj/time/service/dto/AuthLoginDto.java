package com.mj.time.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mj.time.domain.User;
import lombok.Data;

@Data
public class AuthLoginDto {
    private String userNameOrMobile;

    private String password;

    //服务器jwt token
    private String token;

    //value = "用户信息
    private User userInfo;
}
