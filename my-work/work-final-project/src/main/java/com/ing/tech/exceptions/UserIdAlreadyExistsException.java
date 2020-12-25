package com.ing.tech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserIdAlreadyExistsException extends RuntimeException{
    public UserIdAlreadyExistsException() {
        super("User with this national ID already exists.");
    }
}
