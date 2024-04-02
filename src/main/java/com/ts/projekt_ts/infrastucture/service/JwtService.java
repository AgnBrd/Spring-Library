package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.commonTypes.UserRole;
import com.ts.projekt_ts.infrastucture.entity.AuthEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    long tokenLifeTime = 1000 * 60 * 24;
    @Value("$token.signing.key")
    String jwtSigningKey;
    public String generateToken(AuthEntity userDetails){

        return generateToken(new HashMap<>(), userDetails);
    }

    public UserRole extractRole(String token){
        String roleString = extractClaim(token, (claims) -> claims.get("role", String.class));
        return UserRole.valueOf(roleString);
    }
    public boolean isTokenValid(String token){
        try{
            return !isTokenExpired(token);
        }catch (Exception e){
            return false;
        }
    }
    public String extractUsername(String token){

        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token){

        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token){

        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims clamis = extractAllClaims(token);
        return claimsResolver.apply(clamis);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(getSingingKey()).build().parseSignedClaims(token).getPayload();
    }

    public String generateToken(Map<String, Object> extraClaims, AuthEntity userDetails){
        extraClaims.put("role", userDetails.getRole());
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + tokenLifeTime))
                .signWith(getSingingKey())
                .compact();
    }

    private SecretKey getSingingKey(){
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
