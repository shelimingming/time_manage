package com.mj.time.util.convert;

import com.mj.time.domain.User;
import com.mj.time.service.dto.UserInfoDto;

public class UserInfoDtoConvert {
    public static User convertToUser(UserInfoDto userInfoDto) {
        User user = new User();
        user.setNickname(userInfoDto.getNickName());
        user.setWxOpenId(userInfoDto.getOpenId());
        user.setSex(userInfoDto.getGender().byteValue());
        user.setAddress(userInfoDto.getCountry() + "|" + userInfoDto.getProvince() + "|" + userInfoDto.getCity());
        user.setHeadimg(userInfoDto.getAvatarUrl());
        return user;
    }
}
