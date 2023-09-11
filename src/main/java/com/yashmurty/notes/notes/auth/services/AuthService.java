package com.yashmurty.notes.notes.auth.services;

import com.yashmurty.notes.notes.auth.dtos.SignupInput;
import com.yashmurty.notes.notes.auth.dtos.SignupOutput;
import com.yashmurty.notes.notes.auth.exceptions.EmailAlreadyExistsException;
import com.yashmurty.notes.notes.auth.exceptions.UsernameAlreadyExistsException;
import com.yashmurty.notes.notes.user.dtos.CreateUserInput;
import com.yashmurty.notes.notes.user.dtos.CreateUserOutput;
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
        var signupOutput = convertToSignupOutput(userService.createUser(convertToCreateUserInput(signupInput)));

        // Return success response.
        return signupOutput;
    }

    /**
     * Mapper functions. These functions are used to convert from one object to another.
     * Will consider moving them to a separate mapper package if the number of functions increase.
     */
    private static CreateUserInput convertToCreateUserInput(SignupInput signupInput) {
        return new CreateUserInput(signupInput.getUsername(), signupInput.getEmail(), signupInput.getPassword());
    }

    private static SignupOutput convertToSignupOutput(CreateUserOutput createUserOutput) {
        return new SignupOutput(createUserOutput.getEmail());
    }
}
