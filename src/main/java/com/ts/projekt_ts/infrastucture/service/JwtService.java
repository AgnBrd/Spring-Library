package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.infrastucture.entity.AuthEntity;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
public class JwtService {
    public String generateToken(AuthEntity userDetails){
        return null;
    }

    public boolean isTokenValid(String token){
        isTokenExpired(token);
        veryfy(token);
        return true;
    }

    private boolean isTokenExpired(String token){
        return false;
    }

    private boolean veryfy(String token) {
        return true;
    }
    private String generateToken(Map<String, Object> extraClames, AuthEntity userDetails){

        return "ss";
    }

}
