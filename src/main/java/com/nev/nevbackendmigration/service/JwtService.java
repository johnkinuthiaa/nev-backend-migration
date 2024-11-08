package com.nev.nevbackendmigration.service;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private final String SECRETKEY ="";
    private final Long EXPIRATION =null;

    protected SecretKey generateKey(){
        byte[] keyBytes =Decoder
    }

    public String generateJwtToken(String username){
        Map<String,Object> claims =new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis())+EXPIRATION)
                .and()
                .signWithKey(generateKey())
                .comapct();

    }
}
