package com.yashmurty.notes.notes.common.exceptions;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        final ErrorMessage message = new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            LocalDateTime.now(),
            ex.getMessage(),
            request.getDescription(false),
            ex.getClass(),
            ex.getClass().getSimpleName()
        );

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request) {
        final Map<String, String> errors = ex
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

        ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now(),
            "Failed to validate the input.",
            request.getDescription(false),
            errors,
            ex.getClass().getSimpleName()
        );
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(
        IllegalArgumentException ex,
        WebRequest request
    ) {
        final ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now(),
            ex.getMessage(),
            request.getDescription(false),
            ex.getClass(),
            ex.getClass().getSimpleName()
        );

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
