package com.yashmurty.notes.notes.common.exceptions;

import java.time.LocalDateTime;

public record ErrorMessage(
    int statusCode,
    LocalDateTime timestamp,
    String message,
    String description,
    Object errorDetails,
    String exceptionType
) {}
