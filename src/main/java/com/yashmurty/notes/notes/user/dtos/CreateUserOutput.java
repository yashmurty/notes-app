package com.yashmurty.notes.notes.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserOutput {

    private String username;
    private String email;
}
