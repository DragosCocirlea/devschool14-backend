package com.ing.tech.atm.transaction;

import com.ing.tech.atm.Account;

public class Deposit implements Transaction {

    @Override public void execute(Account account, double amount) {
        if (amount < 0) {
            throw new TransactionException("Deposit failed");
        }

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
    }
}
