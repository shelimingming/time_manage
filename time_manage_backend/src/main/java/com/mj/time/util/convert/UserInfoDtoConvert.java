package com.mj.time.util.convert;

import com.mj.time.domain.User;
import com.mj.time.service.dto.WXUserInfoDto;

public class UserInfoDtoConvert {
    public static User convertToUser(WXUserInfoDto WXUserInfoDto) {
        User user = new User();
        user.setNickname(WXUserInfoDto.getNickName());
        user.setWxOpenId(WXUserInfoDto.getOpenId());
        user.setSex(WXUserInfoDto.getGender().byteValue());
        user.setAddress(WXUserInfoDto.getCountry() + "|" + WXUserInfoDto.getProvince() + "|" + WXUserInfoDto.getCity());
        user.setHeadimg(WXUserInfoDto.getAvatarUrl());
        return user;
    }
}
