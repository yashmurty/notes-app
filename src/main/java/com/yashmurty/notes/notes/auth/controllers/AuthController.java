package com.yashmurty.notes.notes.auth.controllers;

import com.yashmurty.notes.notes.common.constants.Constants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constants.BASE_URI + "/auth")
public class AuthController {

    @PostMapping("/signup")
    public String signup() {
        return "Welcome to Signup endpoint.";
    }

    @PostMapping("/login")
    public String authenticate() {
        return "Welcome to Login endpoint.";
    }
}
