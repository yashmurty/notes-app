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
        return true;
    }

    public CreateUserOutput createUser(CreateUserInput createUserInput) {
        return new CreateUserOutput(createUserInput.getEmail());
    }
}
