package com.yashmurty.notes.notes.auth.exceptions;

import java.io.Serial;

public class UsernameAlreadyExistsException extends IllegalArgumentException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UsernameAlreadyExistsException() {
        super("Username already exists!");
    }
}
