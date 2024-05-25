package com.example.servidor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidIdentificationTypeException extends RuntimeException {

    public InvalidIdentificationTypeException(String identificationType) {
        super("Invalid identificationType: " + identificationType);
    }
}
