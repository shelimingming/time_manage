package com.mj.time.util;

import com.mj.time.TimeApplication;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimeApplication.class)
@ActiveProfiles("dev")
public class JwtTokenUtilsTest {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Test
    public void test() throws Exception {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId",123456);
        String token = jwtTokenUtils.createToken(claims);
        System.out.println(token);
        Claims claimsFromToken = jwtTokenUtils.getClaimsFromToken(token);
    }
}
