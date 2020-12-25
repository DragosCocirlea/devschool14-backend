package com.ing.tech.atm.transaction;

import com.ing.tech.atm.Account;
import com.ing.tech.atm.CashDispenser;

public class Withdraw implements Transaction {

    private CashDispenser cashDispenser;

    public Withdraw(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    @Override public void execute(Account account, double choice) {
        double amount = resolveWithdrawAmount((int)choice);

        if (amount > account.getBalance()) {
            throw new TransactionException("Withdraw failed");
        }

        cashDispenser.checkAmount(amount);

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
    }

    private double resolveWithdrawAmount(int choice) {
        double withdrawAmount;
        switch (choice) {
            case 1:
                withdrawAmount = 20;
                break;
            case 2:
                withdrawAmount = 40;
                break;
            case 3:
                withdrawAmount = 60;
                break;
            case 4:
                withdrawAmount = 100;
                break;
            case 5:
                withdrawAmount = 200;
                break;
            default:
                throw new RuntimeException("Invalid withdraw choice");
        }
        return withdrawAmount;
    }
}
