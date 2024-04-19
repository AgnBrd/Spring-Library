package com.ts.projekt_ts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IncorrectPasswordException extends Exception{
    private IncorrectPasswordException(String message) {super(message);}

    public static ResponseStatusException create(){
        com.ts.projekt_ts.exception.IncorrectPasswordException exception = new com.ts.projekt_ts.exception.IncorrectPasswordException(String.format("Incorrect password."));
        return new ResponseStatusException(HttpStatus.UNAUTHORIZED, exception.getMessage(), exception);
    }
}
