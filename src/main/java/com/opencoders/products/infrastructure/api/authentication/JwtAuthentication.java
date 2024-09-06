package com.opencoders.products.infrastructure.api.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthentication {

    private final long expiration = 3600000;
    public boolean isTokenExpired (String token) {
        return extractExpiration(token).before(new Date());
    }
    public boolean isTokenValid (String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername());
    }
    public String extractUsername (String token) {
        Claims claim = extractClaims(token);
        return claim.getSubject();
    }
    private Date extractExpiration (String token) {
        Claims claim = extractClaims(token);
        return claim.getExpiration();
    }
    private Claims extractClaims (String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public String buildToken(UserDetails userDetails) {
        Map<String,Object> extraClaims= new HashMap<>();

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode("4348520549a54e7a6d7d556d69540a8e4405c0f74821ad637e9a1039f4db7f1a");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
