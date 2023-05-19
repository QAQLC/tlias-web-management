package com.tlias.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private final static String signKey = "itheima";
    // 12小时
    private final  static  Long expire = 43200000L;

    /**
     * 生成jwt令牌
     * @param claims jwt 第二部分payload中的内容
     * @return  token
     */
    public static String generateJWT (Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    /**
     * 解析jwt 令牌
     * @param jwt token
     * @return Claims
     */
    public static Claims parseJWT (String jwt) {
        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
