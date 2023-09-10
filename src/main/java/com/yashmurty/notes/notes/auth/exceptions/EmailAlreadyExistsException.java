package com.yashmurty.notes.notes.auth.exceptions;

import java.io.Serial;

public class EmailAlreadyExistsException extends IllegalArgumentException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EmailAlreadyExistsException() {
        super("Email already exists!");
    }
}
