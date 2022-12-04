package com.csc4003.apis;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class JWTAuth {

    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateJWT() {
        Date dt = new Date();
        LocalDateTime.from(dt.toInstant()).plusDays(1);

        return Jwts.builder().setSubject("auth").setExpiration(dt).signWith(key).compact();
    }
    public static String generateJWTWithEmail(String email) {
        Date dt = new Date();
        LocalDateTime.from(dt.toInstant()).plusDays(1);

        return Jwts.builder().setSubject("auth").claim("email", email).setExpiration(dt).signWith(key).compact();
    }

    public static boolean authJWT(String jwt) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject().equals("auth");
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean authJWTWithEmail(String jwt, String email) {

        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject().equals(email);
        }
        catch (Exception e) {
            return false;
        }
    }

    public static String getEmailFromJWT(String jwt) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().get("email").toString();
    }
}
