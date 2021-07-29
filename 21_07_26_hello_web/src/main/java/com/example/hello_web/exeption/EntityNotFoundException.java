package com.example.hello_web.exeption;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityNotFoundMsg) {
        super(entityNotFoundMsg);
    }
}
