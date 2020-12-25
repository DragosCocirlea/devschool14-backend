package com.ing.tech.course3.atm;

import com.ing.tech.course3.atm.transaction.Deposit;
import com.ing.tech.course3.atm.transaction.Transaction;
import com.ing.tech.course3.atm.transaction.TransactionException;
import com.ing.tech.course3.atm.transaction.Withdraw;

public class ATM {
    private Screen screen;
    private Keypad keypad;
    private BankDatabase database;
    private CashDispenser cashDispenser;

    private Account currentUser;

    public ATM() {
        screen = new Screen();
        keypad = new Keypad();
        database = new BankDatabase();
        cashDispenser = new CashDispenser();
    }

    public void run() {
        while (true) {
            if (currentUser == null) {
                login();
                continue;
            }

            displayMenu();

            int actionChosen = keypad.getInput();

            if (!executeAction(actionChosen)) {
                return;
            }
        }
    }

    private void login() {
        screen.displayMessage("Welcome to ING");
        screen.displayMessage("Please insert your account number: ");
        int accountNumber = keypad.getInput();
        screen.displayMessage("Please insert your pin: ");
        int pin = keypad.getInput();

        Account account = database.getAccount(accountNumber);
        if (account == null) {
            screen.displayMessage("Incorrect login information");
            return;
        }

        if (!account.checkPin(pin)) {
            screen.displayMessage("Incorrect login information");
            return;
        }

        currentUser = account;
        screen.displayMessage("You're successfully authenticated");
    }

    private boolean executeAction(int actionChosen) {
        switch (actionChosen) {
            case 1:
                screen.displayMessage("You balance is " + currentUser.getBalance());
                break;
            case 2:
                executeTransaction(new Deposit());
                break;
            case 3:
                displayWithdrawMenu();
                executeTransaction(new Withdraw(cashDispenser));
                break;
            case 4:
                currentUser = null;
                break;
            case 5:
                return false;
            default:
                screen.displayMessage("Invalid command");
                break;
        }
        return true;
    }

    private void executeTransaction(Transaction transaction) {
        screen.displayMessage("Enter the amount");
        double amount = keypad.getAmount();
        try {
            transaction.execute(currentUser, amount);
        } catch (CashDispenserException | TransactionException e) {
            screen.displayMessage(e.getMessage());
        }
        screen.displayMessage("You new balance is " + currentUser.getBalance());
    }

    private void displayWithdrawMenu() {
        screen.displayMessage("1. 20$");
        screen.displayMessage("2. 40$");
        screen.displayMessage("3. 60$");
        screen.displayMessage("4. 100$");
        screen.displayMessage("5. 200$");
    }

    private void displayMenu() {
        screen.displayMessage("-----------------------------------------------");
        screen.displayMessage("Choose one of the following actions:");
        screen.displayMessage("1. View balance.");
        screen.displayMessage("2. Deposit.");
        screen.displayMessage("3. Withdraw.");
        screen.displayMessage("4. Logout.");
        screen.displayMessage("5. Exit.");
    }
}
