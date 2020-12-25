package com.ing.tech.course3.atm;

import java.util.Scanner;

public class Keypad {
    private final Scanner scanner;

    public Keypad() {
        scanner = new Scanner(System.in);
    }

    public int getInput() {
        return scanner.nextInt();
    }

    public double getAmount() {
        return scanner.nextDouble();
    }
}
