package com.slippery.nevmigration.service;

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
    private final String SECRETKEY ="867af1e39cd44e8c926180952f8ddbbc39cb57b2516c3e32dcc38f21d1a9b5ea90eb8f59ecbcd49f790f7cc389211934d1f627b3b023d426c1b6fbc2c9ef6c9140adc66cce0ce23e98d2fa3c4e28103ee087fd0e88bc5a45aa25e75f0ff900e70998af5432fa84723bea9380b568a575da3c0628452187354c923648c41ee24feede3e3920f8c854cc1917f6a3ad143beada2d67ea05d63fc873ed54ca4f368a20e8f2b4a0a5be0c0c20123b2e0bf6f73dfa5dfc55bcfbebb7a9298d8c9e1ee815308ed3ebdcc8e27bb8c7739ca56e128dba3cadc5c3b8713bb0f7bb9d29c18162ed353f683d217a5b844d72325aee2a1ba9582c4c05fa88ae5707f5789dc5b4";
    private final Long EXPIRATION =86400000L;

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
