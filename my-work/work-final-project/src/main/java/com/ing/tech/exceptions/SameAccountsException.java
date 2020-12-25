package com.ing.tech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SameAccountsException extends RuntimeException{
    public SameAccountsException() {
        super("The sending and the receiving account cannot be the same.");
    }
}
