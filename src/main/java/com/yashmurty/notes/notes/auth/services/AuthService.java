package com.yashmurty.notes.notes.auth.services;

import com.yashmurty.notes.notes.auth.dtos.SignupInput;
import com.yashmurty.notes.notes.auth.dtos.SignupOutput;
import com.yashmurty.notes.notes.auth.exceptions.EmailAlreadyExistsException;
import com.yashmurty.notes.notes.auth.exceptions.UsernameAlreadyExistsException;
import com.yashmurty.notes.notes.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SignupOutput signup(SignupInput signupInput) {
        if (userService.checkIfUsernameExists(signupInput.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }
        if (userService.checkIfEmailExists(signupInput.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        signupInput.setPassword(passwordEncoder.encode(signupInput.getPassword()));
        System.out.println(signupInput);

        // Create user account.

        // Return success response.
        return new SignupOutput(signupInput.getEmail());
    }
}
