package com.csc4003.apis;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.HashMap;

public class JWTAuth {

    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateJWT() {
        return Jwts.builder().setSubject("auth").signWith(key).compact();
    }
    public static String generateJWTWithEmail(String email) {
        return Jwts.builder().setSubject("auth").claim("email", email).signWith(key).compact();
    }

    public static boolean authJWT(String jwt) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject().equals("auth");
    }

    public static boolean authJWTWithEmail(String jwt, String email) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject().equals(email);
    }

    public static String getEmailFromJWT(String jwt) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().get("email").toString();
    }
}
