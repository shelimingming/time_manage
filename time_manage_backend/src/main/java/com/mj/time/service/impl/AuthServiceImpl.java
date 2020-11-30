package com.mj.time.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mj.time.common.AuthTypeEnum;
import com.mj.time.config.JwtSecurityProperties;
import com.mj.time.domain.User;
import com.mj.time.mapper.UserMapper;
import com.mj.time.service.AuthService;
import com.mj.time.service.dto.AuthUserDto;
import com.mj.time.service.dto.UserInfoDto;
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
    public AuthUserDto login(AuthUserDto authUserDto) {
        log.info("用户登陆：authUserDto：{}", authUserDto);

        if (AuthTypeEnum.WECHAT.getValue().equals(authUserDto.getAuthType())) {
            //微信登陆
            Code2SessionResp code2SessionResp = wxService.jscode2session(appId, secret, authUserDto.getCode(), "authorization_code");
            if (StringUtils.isEmpty(code2SessionResp.getOpenid())) {
                log.error("wxService.jscode2session失败");
            }
            authUserDto.setOpenId(code2SessionResp.getOpenid());

            //判断用户表中是否存在该用户，不存在则进行解密得到用户信息，并进行新增用户
            User user = userMapper.selectByWXOpenId(code2SessionResp.getOpenid());
            if (user == null) {
                String userInfo = WeChatUtil.decryptData(authUserDto.getEncryptedData(), code2SessionResp.getSession_key(), authUserDto.getIv());
                log.info("userInfo:{}", userInfo);

                UserInfoDto userInfoDto = JSONObject.parseObject(userInfo, UserInfoDto.class);
                user = UserInfoDtoConvert.convertToUser(userInfoDto);

                //todo
                //user.setUnionId(unionId);
                userMapper.insert(user);
                authUserDto.setUserInfo(user);
            } else {
                authUserDto.setUserInfo(user);
            }
        } else {
            //用户名密码登陆
        }

        //创建token
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("roles", "user");
        String token = jwtTokenUtils.createToken(AuthTypeEnum.WECHAT.getValue().equals(authUserDto.getAuthType()) ? authUserDto.getOpenId() : authUserDto.getUserName(), claims);
        log.info("token:{}", token);
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("生成token错误");
        }
        authUserDto.setToken(jwtTokenUtils.jwtSecurityProperties.getTokenStartWith() + token);

        return authUserDto;
    }
}
