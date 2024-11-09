package com.nev.nevbackendmigration.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private final String SECRETKEY ="";
    private final Long EXPIRATION =null;

    protected SecretKey generateKey(){
        byte[] keyBytes = Base64.getDecoder().decode(SECRETKEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJwtToken(String username){
        Map<String,Object> claims =new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION))
                .and()
                .signWith(generateKey())
                .compact();

    }
}
