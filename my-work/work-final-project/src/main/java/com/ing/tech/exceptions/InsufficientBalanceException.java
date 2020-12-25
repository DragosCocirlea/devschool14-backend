package com.ing.tech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException() {
        super("You do not have enough money to make this transaction.");
    }
}
