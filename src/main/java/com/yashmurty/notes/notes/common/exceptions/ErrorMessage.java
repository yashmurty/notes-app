package com.yashmurty.notes.notes.common.exceptions;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorMessage {

    private final int statusCode;
    private final LocalDateTime timestamp;
    private final String message;
    private final String description;
    private final Object errorDetails;
    private final String exceptionType;

    public ErrorMessage(
        int statusCode,
        LocalDateTime timestamp,
        String message,
        String description,
        Object errorDetails,
        String exceptionType
    ) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
        this.errorDetails = errorDetails;
        this.exceptionType = exceptionType;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public Object getErrorDetails() {
        return errorDetails;
    }

    public String getExceptionType() {
        return exceptionType;
    }
}
