package com.mj.time.wechat.service;

import com.mj.time.TimeApplication;
import com.mj.time.wechat.model.Code2SessionResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimeApplication.class)
@ActiveProfiles("dev")
public class WXServiceTest {
    @Value("${wechat.appid}")
    private String appId;
    @Value("${wechat.secret}")
    private String secret;

    @Autowired
    private WXService wxService;

    @Test
    public void test() {
        Code2SessionResp authorization_code = wxService.jscode2session(appId, secret, "081CPI000CJUIK1jFH100JR5eu4CPI0-", "authorization_code");
        System.out.println(authorization_code);
    }
}
