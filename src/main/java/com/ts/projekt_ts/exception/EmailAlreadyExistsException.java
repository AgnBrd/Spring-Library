package com.ts.projekt_ts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistsException extends RuntimeException{
    private EmailAlreadyExistsException(String message){
        super(message);
    }

    public static ResponseStatusException create(String email){
        EmailAlreadyExistsException exception = new EmailAlreadyExistsException(String.format("User with email: %s already exists.", email));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}
