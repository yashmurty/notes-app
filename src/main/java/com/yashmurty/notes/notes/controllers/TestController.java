package com.yashmurty.notes.notes.controllers;

import com.yashmurty.notes.notes.common.constants.Constants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constants.BASE_URI + "/")
public class TestController {

    @GetMapping("/")
    public String root() {
        return "Welcome to test controller endpoints.";
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Hello world! This message is accessible to all.";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "All logged in users can access this message.";
    }

    @GetMapping("/mod")
    public String moderatorAccess() {
        return "Users with moderator role can access this message.";
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return "Users with admin role can access this message.";
    }
}
