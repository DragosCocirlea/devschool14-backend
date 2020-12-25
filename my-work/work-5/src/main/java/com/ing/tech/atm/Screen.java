package com.ing.tech.atm;

import org.springframework.stereotype.Service;

@Service
public class Screen {

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
