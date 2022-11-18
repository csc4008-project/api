package com.csc4003.apis;

import com.csc4003.apis.models.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @CrossOrigin
    @GetMapping("/login")
    public User getUser(@RequestParam(value = "userId") String userId)
    {
        return new User(userId, "Test User");
    }
}
