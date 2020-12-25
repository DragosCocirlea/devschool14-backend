package com.ing.tech.cvService.exceptions;

public class CVNotFoundException extends RuntimeException {
    public CVNotFoundException(String message) {
        super(message);
    }
}
