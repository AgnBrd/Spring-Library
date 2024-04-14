package com.ts.projekt_ts.infrastucture.service;


import com.ts.projekt_ts.commonTypes.UserRole;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    long tokenLifeTime = 1000 * 60 * 24; // to change

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    /**
     * Generates a JWT token for the given user details.
     * @param userDetails the user details for whom the token is generated
     * @return a JWT token as a String
     */
    public String generateToken(UserEntity userDetails){

        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Extracts the role from the JWT token.
     * @param token the JWT token
     * @return the role extracted from the token
     */
    public UserRole extractRole(String token){
        String roleString = extractClaim(token, (claims) -> claims.get("role", String.class));
        return UserRole.valueOf(roleString);
    }

    /**
     * Validates if a JWT token is still valid.
     * @param token the JWT token
     * @return true if the token is valid, otherwise false
     */
    public boolean isTokenValid(String token){
        try{
            return !isTokenExpired(token);
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Extracts the username from the JWT token.
     * @param token the JWT token
     * @return the username extracted from the token
     */
    public String extractUsername(String token){

        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token){

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

    /**
     * Generates a JWT token with additional claims for the given user details.
     * @param extraClaims additional claims to include in the token
     * @param userDetails the user details for whom the token is generated
     * @return a JWT token as a String
     */
    public String generateToken(Map<String, Object> extraClaims, UserEntity userDetails){
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
