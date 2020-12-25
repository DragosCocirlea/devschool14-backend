package com.ing.tech.atm;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Repository
public class CashDispenser {
    private int noOfBills;
    private final String fileName = "cashdispenser.txt";

    public CashDispenser() {
        noOfBills = readFromFile();
        System.out.println("Cash Dispenser loaded");
    }

    private int readFromFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String filePath = new File(classLoader.getResource(fileName).getFile()).getAbsolutePath();
            return Integer.parseInt(Files.readAllLines(Paths.get(filePath)).get(0));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during CashDispenser read");
        }
    }

    public void checkAmount(double amount) {
        if(amount > 20 * noOfBills) {
            throw new CashDispenserException("Not enough bills");
        }

        if(amount % 20 != 0) {
            throw new CashDispenserException("Amount should be multiple of 20$");
        }

        noOfBills -= amount / 20;
    }
}
