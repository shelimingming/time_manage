package com.mj.time.controller;

import com.mj.time.annotation.NoNeedToken;
import com.mj.time.common.CommonResponse;
import com.mj.time.service.AuthService;
import com.mj.time.service.dto.AuthLoginDto;
import com.mj.time.service.dto.WXAuthLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time/auth")
@NoNeedToken
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public CommonResponse<AuthLoginDto> login(@RequestBody AuthLoginDto authLoginDto) {
        AuthLoginDto authLoginDtoResp = authService.login(authLoginDto);
        return new CommonResponse<AuthLoginDto>(authLoginDtoResp);
    }

    @PostMapping(value = "/wxlogin")
    public CommonResponse<WXAuthLoginDto> wxlogin(@RequestBody WXAuthLoginDto wxAuthLoginDto) {
        WXAuthLoginDto wxAuthLoginDtoResp = authService.wxLogin(wxAuthLoginDto);
        return new CommonResponse<WXAuthLoginDto>(wxAuthLoginDtoResp);
    }
}
