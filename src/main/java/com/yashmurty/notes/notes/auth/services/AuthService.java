package com.yashmurty.notes.notes.auth.services;

import com.yashmurty.notes.notes.auth.dtos.SignupInput;
import com.yashmurty.notes.notes.auth.dtos.SignupOutput;
import com.yashmurty.notes.notes.auth.exceptions.EmailAlreadyExistsException;
import com.yashmurty.notes.notes.auth.exceptions.UsernameAlreadyExistsException;
import com.yashmurty.notes.notes.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    public SignupOutput signup(SignupInput signupInput) {
        // Log the signupInput object.
        System.out.println(signupInput);
        // Check if username & email already exists
        if (userService.checkIfUsernameExists(signupInput.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }
        if (userService.checkIfEmailExists(signupInput.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        // Create user account. Hash the password.
        // Return success response.
        return new SignupOutput(signupInput.getEmail());
    }
}
