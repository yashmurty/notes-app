package com.yashmurty.notes.notes.auth.services;

import com.yashmurty.notes.notes.auth.dtos.SignupInput;
import com.yashmurty.notes.notes.auth.dtos.SignupOutput;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public SignupOutput signup(SignupInput signupInput) {
        // Log the signupInput object.
        System.out.println(signupInput);
        // Check if username & email already exists

        // Create user account. Hash the password.
        // Return success response.
        return new SignupOutput(signupInput.getEmail());
    }
}
