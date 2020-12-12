package com.mj.time.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class JwtTokenUtils {
    /**
     * 秘钥
     */
    @Value("${jwt.secret:52GLLfnJ30xJ0qCBgPMVUOatf4BUJvGMejJzXD418HQ=}")
    private String secret;
    /**
     * 有效期，单位秒
     * - 默认2周
     */
    @Value("${jwt.expire-time-in-second:1209600}")
    private Long expirationTimeInSecond;

    /**
     * 为指定用户生成token
     *
     * @param claims 用户信息
     * @return token
     */
    public String createToken(Map<String, Object> claims) {
        Date createdTime = new Date();
        Date expirationTime = this.getExpirationTime();

        byte[] keyBytes = secret.getBytes();
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        String token = Jwts.builder()
                .setClaims(claims)               //设置自定义属性
                .setIssuedAt(createdTime)        //设置token创建时间
                .setExpiration(expirationTime)   //设置token过期时间
                .signWith(key, SignatureAlgorithm.HS256)  //// 支持的算法详见：https://github.com/jwtk/jjwt#features
                .compact();

        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public Boolean verifyToken(String token) {
        byte[] keyBytes = secret.getBytes();
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException ex) {
            log.error("token:{},验证失败", token, ex);
            return false;
        }
    }

    /**
     * 从token中获取claim
     *
     * @param token token
     * @return claim
     */
    public Claims getClaimsFromToken(String token) {
        byte[] keyBytes = secret.getBytes();
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            Claims claims = jws.getBody();
            return claims;
        } catch (JwtException ex) {
            log.error("token:{},验证失败", token, ex);
            throw new RuntimeException("token验证失败");
        }
    }

    /**
     * 生成随机合法密钥，然后手动保存到配置文件。密钥千万不能泄漏！！！
     *
     * @return
     */
    public String generateSecretString() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512
        String secretString = Encoders.BASE64.encode(key.getEncoded());
        return secretString;
    }

    public static void main(String[] args) {
        System.out.println(new JwtTokenUtils().generateSecretString());
    }

    /**
     * 计算token的过期时间
     *
     * @return 过期时间
     */
    private Date getExpirationTime() {
        return new Date(System.currentTimeMillis() + this.expirationTimeInSecond * 1000);
    }
}
