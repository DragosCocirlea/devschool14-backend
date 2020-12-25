package com.ing.tech.course3.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainBad {
    private static Account currentUser;
    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        accounts.put(1, new Account(1, 1, 1000));
        accounts.put(2, new Account(2, 2, 500));
        accounts.put(3, new Account(3, 3, 7000));

        while(true) {
            if (currentUser == null) {
                login();
                continue;
            }

            System.out.println("-----------------------------------------------");
            System.out.println("Choose one of the following actions:");
            System.out.println("1. View balance.");
            System.out.println("2. Deposit.");
            System.out.println("3. Withdraw.");
            System.out.println("4. Logout.");
            System.out.println("5. Exit.");

            int actionChosen = scanner.nextInt();

            if (!executeAction(actionChosen)) {
                return;
            }
        }
    }

    private static void login() {
        System.out.println("Welcome to ING");
        System.out.println("Please insert your account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Please insert your pin: ");
        int pin = scanner.nextInt();

        Account account = getAccount(accountNumber);
        if (account == null) {
            System.out.println("Incorrect login information");
            return;
        }

        if(!account.checkPin(pin)) {
            System.out.println("Incorrect login information");
            return;
        }

        currentUser = account;
        System.out.println("You're successfully authenticated");
    }

    private static boolean executeAction(int actionChosen) {
        switch (actionChosen) {
            case 1:
                System.out.println("You balance is " + currentUser.getBalance());
                break;
            case 2:
                System.out.println("Enter the amount");
                double amount = scanner.nextDouble();
                if (amount < 0) {
                    throw new RuntimeException("Deposit failed");
                }

                double newBalance = currentUser.getBalance() + amount;
                currentUser.setBalance(newBalance);
                System.out.println("You new balance is " + currentUser.getBalance());
                break;
            case 3:
                System.out.println("1. 20$");
                System.out.println("2. 40$");
                System.out.println("3. 60$");
                System.out.println("4. 100$");
                System.out.println("5. 200$");
                System.out.println("Enter the amount");
                int choice = scanner.nextInt();

                double am;
                switch (choice) {
                    case 1:
                        am = 20;
                        break;
                    case 2:
                        am = 40;
                        break;
                    case 3:
                        am = 60;
                        break;
                    case 4:
                        am = 100;
                        break;
                    case 5:
                        am = 200;
                        break;
                    default:
                        throw new RuntimeException("Invalid withdraw choice");
                }
                if (am > currentUser.getBalance()) {
                    throw new RuntimeException("Withdraw failed");
                }

                currentUser.setBalance(currentUser.getBalance() - am);
                System.out.println("You new balance is " + currentUser.getBalance());
                break;
            case 4:
                currentUser = null;
                break;
            case 5:
                return false;
            default:
                System.out.println("Invalid command");
                break;
        }

        return true;
    }

    public static Account getAccount(int accountId) {
        return accounts.get(accountId);
    }
}
