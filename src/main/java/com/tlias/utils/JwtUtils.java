package com.tlias.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String signKey = "Jane";
    private static final long expire = 1000 * 60 * 60;

    private JwtUtils() {}

    public static String generateJwt(Map<String, Object> claims) {
        return Jwts
            .builder()
            .signWith(SignatureAlgorithm.HS256, signKey)
            .setClaims(claims)
            .setExpiration(new Date(System.currentTimeMillis() + expire))
            .compact();
    }

    public static Map<String, Object> parseJwt(String token) {
        return Jwts.parser().setSigningKey(signKey).parseClaimsJws(token).getBody();
    }
}
