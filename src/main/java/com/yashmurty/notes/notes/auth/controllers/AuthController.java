package com.yashmurty.notes.notes.auth.controllers;

import com.yashmurty.notes.notes.auth.dtos.LoginInput;
import com.yashmurty.notes.notes.auth.dtos.LoginOutput;
import com.yashmurty.notes.notes.auth.dtos.SignupInput;
import com.yashmurty.notes.notes.auth.dtos.SignupOutput;
import com.yashmurty.notes.notes.auth.services.AuthService;
import com.yashmurty.notes.notes.common.constants.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constants.BASE_URI + "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupInput signupInput) {
        var signupOutput = authService.signup(signupInput);
        return ResponseEntity.ok(signupOutput);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginInput loginInput) {
        return ResponseEntity.ok(new LoginOutput(loginInput.getEmail()));
    }
}
