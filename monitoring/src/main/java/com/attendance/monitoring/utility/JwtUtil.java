package com.attendance.monitoring.utility;


import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {
    
    //
    // public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    // //
    // private String secret = "thisIsMysecregtfrdesww233eggtffeeddgkjjhhtdhttebd54ndhdhfhhhshs8877465sbbdd";

    // //
    // private SecretKey key;
    
    // //preventing the repeated creation of the key
    // @PostConstruct
    // public void init(){
    //     this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    // }
    
    // //retrieve username from jwt token
    // public String getUsernameFromToken(String token) {
    //     return getClaimFromToken(token, Claims::getSubject);
    // }

    // //retrieve expiration date from jwt token
    // public Date getExpirationDateFromToken(String token) {
    //     return getClaimFromToken(token, Claims::getExpiration);
    // }

    // public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    //     final Claims claims = getAllClaimsFromToken(token);
    //     return claimsResolver.apply(claims);
    // }

    // //for retrieveing any information from token we will need the secret key
    // private Claims getAllClaimsFromToken(String token) {
    //     // return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    //     return Jwts
    //             .parserBuilder()
    //             .setSigningKey(key)
    //             .build()
    //             .parseClaimsJws(token)
    //             .getBody();
    // }

    // //generate token for user
    // public String generateToken(UserDetails userDetails) {
    //     // Map<String, Object> claims = new HashMap<>();
    //     return doGenerateToken(userDetails.getUsername());
    // }

    // //while creating the token -
    // //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    // //2. Sign the JWT using the HS512 algorithm and secret key.
    // //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    // //   compaction of the JWT to a URL-safe string
    // private String doGenerateToken(String username) {

    //     return Jwts
    //                 .builder()
    //                 .setSubject(username)
    //                 .setIssuedAt(new Date())
    //                 .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
    //                 .signWith(key)
    //                 .compact();
    
    // }

    // //validate token
    // public Boolean validateToken(String token) {
        
    //     try{
    //         Jwts.parserBuilder()
    //             .setSigningKey(key)
    //             .build()
    //             .parseClaimsJws(token);
                
    //             return true;
    //     }catch(SecurityException e){
    //         System.out.println("Invalid JWT signature: " + e.getMessage());
    //     }catch(MalformedJwtException e){
    //         System.out.println("Invalid JWT token: " + e.getMessage());
    //     }catch(ExpiredJwtException e){
    //         System.out.println("JWT token was expired: " + e.getMessage());
    //     }catch(UnsupportedJwtException e){
    //         System.out.println("JWT token is unsupported: " + e.getMessage());
    //     }catch(IllegalArgumentException e){
    //         System.out.println("JWT claims string is empty: " + e.getMessage());
    //     }

    //     return false;
    
    // }


}
