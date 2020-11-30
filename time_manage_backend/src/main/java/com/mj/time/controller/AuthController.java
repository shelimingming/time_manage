package com.mj.time.controller;

import com.mj.time.common.AuthTypeEnum;
import com.mj.time.common.CommonResponse;
import com.mj.time.service.AuthService;
import com.mj.time.service.dto.AuthUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public CommonResponse<AuthUserDto> login(@RequestBody AuthUserDto authUserDto) {

        AuthUserDto authUserDtoRes = authService.login(authUserDto);

        return new CommonResponse<AuthUserDto>(authUserDtoRes);
    }
}
