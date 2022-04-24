package com.example.demo.userapplication.exception;

import org.springframework.lang.NonNull;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomException(@NonNull final String message) {
        super(message);
    }
}
