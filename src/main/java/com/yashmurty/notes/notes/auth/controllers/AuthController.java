package com.yashmurty.notes.notes.auth.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yashmurty.notes.notes.auth.dtos.SignupInput;
import com.yashmurty.notes.notes.auth.dtos.SignupOutput;
import com.yashmurty.notes.notes.common.constants.Constants;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constants.BASE_URI + "/auth")
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupInput signupInput) {
        // Log the signupInput object.
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(signupInput);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error converting object to JSON: " + e.getMessage());
        }

        return ResponseEntity.ok(new SignupOutput(signupInput.getEmail()));
    }

    @PostMapping("/login")
    public String authenticate() {
        return "Welcome to Login endpoint.";
    }
}
