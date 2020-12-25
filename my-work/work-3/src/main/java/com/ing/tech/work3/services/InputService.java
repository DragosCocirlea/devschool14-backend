package com.ing.tech.work3.services;

import java.util.Scanner;

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
