package com.yashmurty.notes.notes.auth.dtos;

public class SignupOutput {

    private String email;

    public SignupOutput(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
