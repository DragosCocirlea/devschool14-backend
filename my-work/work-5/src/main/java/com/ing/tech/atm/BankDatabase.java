package com.ing.tech.atm;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class BankDatabase {

    private static Map<Integer, Account> accounts = new HashMap<>();
    private final String fileName = "database.txt";

    public BankDatabase() {
        readAccounts();
    }

    private void readAccounts() {
        ClassLoader classLoader = getClass().getClassLoader();
        String filePath = new File(classLoader.getResource(fileName).getFile()).getAbsolutePath();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(this::put);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loaded");
    }

    private void put(String line) {
        String[] lineSplit = line.split("-");
        Account account = new Account(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]),
            Double.parseDouble(lineSplit[2])
        );
        accounts.put(account.getId(), account);
    }

    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }
}
