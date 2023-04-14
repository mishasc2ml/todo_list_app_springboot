package com.todolist.backendspring.exception;

import lombok.Getter;

@Getter
public class NotUniqueValueException extends RuntimeException {
    public NotUniqueValueException(String message) {
        super(message);
    }
}
