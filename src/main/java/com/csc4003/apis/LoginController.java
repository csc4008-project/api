package com.csc4003.apis;

import com.csc4003.apis.Services.AttendeeService;
import com.csc4003.apis.Services.BookingService;
import com.csc4003.apis.Services.EmployeeService;
import com.csc4003.apis.models.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.jsonwebtoken.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private AttendeeService attendeeService;

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    @CrossOrigin
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody Map<String, Object> json) {

        Employee emp = employeeService.findByEmail(json.get("email").toString());

        if(emp != null && emp.getPassword().equals(SHAHash(json.get("password").toString()))) {
            HashMap<String, String> response = new HashMap<>() {
                {
                    put("accessToken", generateJWT(emp.getEmail()));
                    put("email", emp.getEmail());
                    put("name", emp.getFullName());
                }};
            return response;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Email or Password is incorrect"
            );
        }
    }

    @CrossOrigin
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, Object> json) {
        if(employeeService.findByEmail(json.get("email").toString()) == null) {

            Employee emp = new Employee(json.get("name").toString(), "", json.get("email").toString(), SHAHash(json.get("password").toString()));

            employeeService.addEmployee(emp);

            HashMap<String, String> response = new HashMap<>() {
                {
                    put("accessToken", generateJWT(emp.getEmail()));
                    put("email", emp.getEmail());
                    put("name", emp.getFullName());
                }};

            return response;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already tied to a user account"
            );
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public Map<String, String> updateAccount(@RequestBody Map<String, Object> json, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth ) {
        if(authJWT(auth.split(" ")[1], json.get("email").toString())) {
            Employee emp = employeeService.findByEmail(json.get("email").toString());

            if(emp != null) {
                emp.setFullName(json.get("name").toString());
                emp.setEmail(json.get("email").toString());

                if (json.get("password").toString() != "") {
                    emp.setPassword(SHAHash(json.get("password").toString()));
                }

                employeeService.updateEmployee(emp);

                HashMap<String, String> response = new HashMap<>() {
                    {
                        put("accessToken", generateJWT(emp.getEmail()));
                        put("email", emp.getEmail());
                        put("name", emp.getFullName());
                    }
                };
                return response;
            }
            else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User does not exist"
                );
            }
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "JWT Token not valid or missing"
            );
        }
    }

    private String generateJWT(String email) {
        return Jwts.builder().setSubject(email).signWith(key).compact();
    }

    private boolean authJWT(String jwt, String email) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject().equals(email);
    }

    private String SHAHash(String password) {
        try {
            MessageDigest message = MessageDigest.getInstance("SHA-512");
            byte[] digest = message.digest(password.getBytes());
            BigInteger num = new BigInteger(1, digest);
            String hash = num.toString(16);

            while(hash.length() < 32) {
                hash = "0" + hash;
            }

            return hash;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
