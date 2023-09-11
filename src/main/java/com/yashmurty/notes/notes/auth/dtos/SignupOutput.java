package com.yashmurty.notes.notes.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupOutput {

    private String email;
    private int id;
}
