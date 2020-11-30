package com.mj.time.util;

import com.mj.time.TimeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimeApplication.class)
@ActiveProfiles("dev")
public class JwtTokenUtilsTest {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Test
    public void test() {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("roles", "user");
        String token = jwtTokenUtils.createToken("123", claims);
        System.out.println("token:" + token);

        Date expirationDate = jwtTokenUtils.getExpirationDateFromToken(token);
        System.out.println("expirationDate:"+expirationDate);

        Authentication authentication = jwtTokenUtils.getAuthentication(token);
        System.out.println("authentication:"+authentication);

        boolean res = jwtTokenUtils.validateToken(token);
        System.out.println("res:"+res);
        
    }
}
