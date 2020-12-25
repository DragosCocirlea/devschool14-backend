package com.ing.tech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AccountNumberAlreadyExistsException extends RuntimeException{
    public AccountNumberAlreadyExistsException() {
        super("This account number has already been taken.");
    }
}
