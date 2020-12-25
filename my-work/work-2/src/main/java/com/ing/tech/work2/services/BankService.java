package com.ing.tech.work2.services;

import com.ing.tech.work2.data.Account;
import com.ing.tech.work2.data.UserCredentials;
import com.ing.tech.work2.exceptions.BackupRestoreException;
import com.ing.tech.work2.exceptions.InsufficientFundsException;
import com.ing.tech.work2.exceptions.WrongCredentialsException;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class BankService {

    static private HashMap<String, Account> bankDatabase;

    public BankService() {
        bankDatabase = new HashMap<>();

        // restore data from backup
        try {
            File bankBackup = new File("./my-work/work-2/BankData.csv");
            Scanner scanner = new Scanner(bankBackup);

            String entry;
            while (scanner.hasNextLine()) {
                entry = scanner.nextLine();
                String[] userData = entry.split(",");

                String userAccount = userData[0];
                String userPin = userData[1];
                String userName = userData[2];
                Integer userBalance = Integer.parseInt(userData[3]);

                bankDatabase.put(userAccount, new Account(userAccount, userPin, userName, userBalance));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new BackupRestoreException("Error restoring backup\n" + e.getMessage());
        }
    }

    public String login(UserCredentials credentials) {
        Account account = bankDatabase.get(credentials.getAccountNumber());

        if (account == null) {
            throw new WrongCredentialsException("Wrong credentials.");
        }

        if (!account.checkPin(credentials.getAccountPin())) {
            throw new WrongCredentialsException("Wrong credentials.");
        }

        return account.getAccountNumber();
    }

    public String getAccountUserName(String accountNumber) {
        return bankDatabase.get(accountNumber).getName();
    }

    public void deposit(String accountNumber, Integer depositAmount) {
        bankDatabase.get(accountNumber).deposit(depositAmount);
    }

    public void checkWithdraw(String accountNumber, Integer withdrawnAmount) throws InsufficientFundsException {
        Account account = bankDatabase.get(accountNumber);

        if (!account.isWithdrawPossible(withdrawnAmount)) {
            throw new InsufficientFundsException("You do not have enough funds for this operation.");
        }
    }

    public void withdraw(String accountNumber, Integer withdrawAmount) throws InsufficientFundsException {
        bankDatabase.get(accountNumber).withdraw(withdrawAmount);
    }

    public Integer getAccountBalance(String accountNumber) {
        return bankDatabase.get(accountNumber).getBalance();
    }


}
