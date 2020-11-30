package com.mj.time.service;

import com.mj.time.service.dto.AuthUserDto;

public interface AuthService {
    AuthUserDto login(AuthUserDto authUserDto);
}
