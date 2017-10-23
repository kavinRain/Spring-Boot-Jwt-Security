package com.spring.boot.util;

import com.google.common.collect.Maps;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public class JwtTokenUtil {

    /**
     * 私钥
     */
    private static String secret="1111";

    public static String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = Maps.newHashMap();
        claims.put("CLAIM_KEY_USERNAME", userDetails.getUsername());
        return Jwts.builder()
                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
