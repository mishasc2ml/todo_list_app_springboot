package com.todolist.backendspring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InputFieldException.class)
    public ResponseEntity<Map<String, String>> handleInputFieldException(InputFieldException exception) {
        InputFieldException inputFieldException = new InputFieldException(exception.getBindingResult());
        return ResponseEntity.badRequest().body(inputFieldException.getErrors());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
        NotFoundException notFoundException = new NotFoundException(exception.getMessage(), exception.getHttpStatus());
        return ResponseEntity.status(notFoundException.getHttpStatus()).body(notFoundException.getMessage());
    }

    @ExceptionHandler(NotUniqueValueException.class)
    public ResponseEntity<String> handleNotUniqueException(NotUniqueValueException exception) {
        NotUniqueValueException notUniqueValueException = new NotUniqueValueException(exception.getMessage());
        return ResponseEntity.badRequest().body(notUniqueValueException.getMessage());
    }
}
