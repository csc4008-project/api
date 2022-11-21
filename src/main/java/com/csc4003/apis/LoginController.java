package com.csc4003.apis;

import com.csc4003.apis.models.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.io.*;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    @CrossOrigin
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody Map<String, Object> json) {
        if(json.get("email").equals("test123") && json.get("password").equals("test123")) {
            HashMap<String, String> response = new HashMap<>() {
                {
                    put("accessToken", generateJWT(json.get("email").toString()));
                    put("email", json.get("email").toString());
                    put("name", "Test User");
                }};
            return response;
        }
        return new HashMap<>();
    }

    @CrossOrigin
    @PostMapping("/register")
    public Employee register() {
        return new Employee();
    }

    @CrossOrigin
    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public Map<String, String> updateAccount(@RequestBody Map<String, Object> json, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth ) {
        if(authJWT(auth.split(" ")[1], json.get("email").toString())) {
            HashMap<String, String> response = new HashMap<>() {
                {
                    put("accessToken", auth.split(" ")[1]);
                    put("email", json.get("email").toString());
                    put("name", json.get("name").toString());
                }};
            return response;
        }

        return new HashMap<>();
    }

    private String generateJWT(String email) {
        return Jwts.builder().setSubject(email).signWith(key).compact();
    }

    private boolean authJWT(String jwt, String email) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject().equals(email);
    }

}
