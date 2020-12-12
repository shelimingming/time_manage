package com.mj.time.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WXUserInfoDto {
    private String openId;
    private String nickName;
    private Integer gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private Watermark watermark;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Watermark {
        private Integer timestamp;
        private String appid;
    }
}
