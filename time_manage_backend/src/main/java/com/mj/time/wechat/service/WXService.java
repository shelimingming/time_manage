package com.mj.time.wechat.service;

import com.mj.time.wechat.model.Code2SessionResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "wxService", url = "${wechat.url}")
public interface WXService {
    /**
     * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。
     *
     * @param appid      小程序 appId
     * @param secret     小程序 appSecret
     * @param js_code    登录时获取的 code
     * @param grant_type 授权类型，此处只需填写 authorization_code
     * @return
     */
    @GetMapping(path = "/sns/jscode2session")
    Code2SessionResp jscode2session(@RequestParam String appid, @RequestParam String secret, @RequestParam String js_code, @RequestParam String grant_type);
}
