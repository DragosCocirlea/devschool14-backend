package com.ing.tech.cvService.services;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class InputService {
    private final Scanner scanner;

    public InputService() {
        scanner = new Scanner(System.in);
    }

    public int getIntegerInput() {
        return scanner.nextInt();
    }

    public String getStringInput() {
        return scanner.next();
    }
}
