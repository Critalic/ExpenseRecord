package com.example.expenserecord.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleRateServiceValidationException(ValidationException e) {
        return ResponseEntity.badRequest().body("Record API error: " + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleRateServiceValidationException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder("Record API error: ");
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errorMessage.append(error.getDefaultMessage()).append("\n");
        }
        return ResponseEntity.badRequest().body(errorMessage.toString());
    }
}
