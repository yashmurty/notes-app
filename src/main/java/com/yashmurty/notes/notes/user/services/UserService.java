package com.yashmurty.notes.notes.user.services;

import com.yashmurty.notes.notes.user.dtos.CreateUserInput;
import com.yashmurty.notes.notes.user.dtos.CreateUserOutput;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean checkIfUsernameExists(String username) {
        return false;
    }

    public boolean checkIfEmailExists(String email) {
        return false;
    }

    public CreateUserOutput createUser(CreateUserInput createUserInput) {
        System.out.println(createUserInput);

        return new CreateUserOutput(createUserInput.getUsername(), createUserInput.getEmail(), 0);
    }
}
