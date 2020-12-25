package com.ing.tech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserEmailAlreadyExistsException extends RuntimeException{
    public UserEmailAlreadyExistsException() {
        super("User with this email already exists.");
    }
}
