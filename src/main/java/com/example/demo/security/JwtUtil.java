package com.example.demo.security; 
 
import io.jsonwebtoken.*; 
import io.jsonwebtoken.security.Keys; 
 
import java.security.Key; 
import java.util.Date; 
 
public class JwtUtil { 
 
    private final Key key; 
    private final long validityInMs; 
 
    public JwtUtil(String secretKey, long validityInMs) { 
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes()); 
        this.validityInMs = validityInMs; 
    } 
 
    public String generateToken(Long userId, String email, String role) { 
        Date now = new Date(); 
        Date expiry = new Date(now.getTime() + validityInMs); 
 
        return Jwts.builder() 
                .setSubject(email) 
                .claim("userId", userId) 
                .claim("role", role) 
                .setIssuedAt(now) 
                .setExpiration(expiry) 
                .signWith(key, SignatureAlgorithm.HS256) 
                .compact(); 
    } 
 
    public Claims parseClaims(String token) { 
        return Jwts.parserBuilder() 
                .setSigningKey(key) 
                .build() 
                .parseClaimsJws(token) 
.getBody(); 
} 
}