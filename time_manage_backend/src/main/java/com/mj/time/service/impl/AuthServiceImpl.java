package com.mj.time.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mj.time.common.AuthTypeEnum;
import com.mj.time.common.BizException;
import com.mj.time.common.Constants;
import com.mj.time.common.ErrorCodeEnum;
import com.mj.time.domain.User;
import com.mj.time.mapper.UserMapper;
import com.mj.time.service.AuthService;
import com.mj.time.service.dto.AuthLoginDto;
import com.mj.time.service.dto.WXAuthLoginDto;
import com.mj.time.service.dto.WXUserInfoDto;
import com.mj.time.util.JwtTokenUtils;
import com.mj.time.util.WeChatUtil;
import com.mj.time.util.convert.UserInfoDtoConvert;
import com.mj.time.wechat.model.Code2SessionResp;
import com.mj.time.wechat.service.WXService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Value("${wechat.appid}")
    private String appId;
    @Value("${wechat.secret}")
    private String secret;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private WXService wxService;

    @Autowired
    private UserMapper userMapper;


    @Override
    public AuthLoginDto login(AuthLoginDto authLoginDto) {
        User user = userMapper.selectByUserNameOrMobile(authLoginDto.getUserNameOrMobile());
        if (user == null || !user.getPassword().equals(authLoginDto.getPassword())) {
            throw new BizException(ErrorCodeEnum.USERNAME_OR_PASSWORD_ERROR);
        } else {
            authLoginDto.setUserInfo(user);

            Map<String, Object> claims = new HashMap<>();
            claims.put(Constants.CLAIMS_USER_ID, user.getId());
            claims.put(Constants.CLAIMS_AUTH_TYPE, AuthTypeEnum.PASSWORD.getValue());
            String token = jwtTokenUtils.createToken(claims);
            authLoginDto.setToken(token);
        }
        return authLoginDto;
    }

    @Override
    public WXAuthLoginDto wxLogin(WXAuthLoginDto WXAuthLoginDto) {
        log.info("微信登陆：authUserDto：{}", WXAuthLoginDto);

        Code2SessionResp code2SessionResp = wxService.jscode2session(appId, secret, WXAuthLoginDto.getCode(), "authorization_code");
        String openid = code2SessionResp.getOpenid();
        if (StringUtils.isEmpty(openid)) {
            log.error("wxService.jscode2session失败");
            throw new BizException(ErrorCodeEnum.WECHAT_LOGIN_FAILED);
        }
        WXAuthLoginDto.setOpenId(openid);

        //判断用户表中是否存在该用户，不存在则进行解密得到用户信息，并进行新增用户
        User user = userMapper.selectByWXOpenId(openid);
        if (user == null) {
            String userInfo = WeChatUtil.decryptData(WXAuthLoginDto.getEncryptedData(), code2SessionResp.getSession_key(), WXAuthLoginDto.getIv());
            log.info("userInfo:{}", userInfo);

            WXUserInfoDto WXUserInfoDto = JSONObject.parseObject(userInfo, WXUserInfoDto.class);
            user = UserInfoDtoConvert.convertToUser(WXUserInfoDto);

            //todo
            //user.setUnionId(unionId);
            userMapper.insert(user);
            WXAuthLoginDto.setUserInfo(user);
        } else {
            WXAuthLoginDto.setUserInfo(user);
        }

        //创建token
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.CLAIMS_USER_ID, user.getId());
        claims.put(Constants.CLAIMS_AUTH_TYPE, AuthTypeEnum.WECHAT.getValue());
        String token = jwtTokenUtils.createToken(claims);

        WXAuthLoginDto.setToken(token);

        return WXAuthLoginDto;
    }


}
