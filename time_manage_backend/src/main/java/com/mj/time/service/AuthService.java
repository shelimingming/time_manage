package com.mj.time.service;

import com.mj.time.service.dto.AuthLoginDto;
import com.mj.time.service.dto.WXAuthLoginDto;

public interface AuthService {
    AuthLoginDto login(AuthLoginDto authLoginDto);

    WXAuthLoginDto wxLogin(WXAuthLoginDto WXAuthLoginDto);
}
