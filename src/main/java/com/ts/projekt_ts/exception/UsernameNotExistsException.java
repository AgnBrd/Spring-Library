package com.ts.projekt_ts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsernameNotExistsException extends RuntimeException{

    private UsernameNotExistsException(String message){
        super(message);
    }

    public static ResponseStatusException create(String username){
        com.ts.projekt_ts.exception.UsernameNotExistsException exception = new com.ts.projekt_ts.exception.UsernameNotExistsException(String.format("Username: %s not found.", username));
        return new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
    }

}
