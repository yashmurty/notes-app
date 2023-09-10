package com.yashmurty.notes.notes.auth.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginInput {

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String password;
}
