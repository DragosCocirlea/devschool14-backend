package com.ing.tech.work2;

import com.ing.tech.work2.data.ATMStates.ATMState;
import com.ing.tech.work2.data.UserCredentials;
import com.ing.tech.work2.exceptions.InsufficientFundsException;
import com.ing.tech.work2.services.BankService;
import com.ing.tech.work2.services.InputService;
import com.ing.tech.work2.services.OutputService;

public class ATM {
    static private BankService bankService;
    static private InputService inputService;
    static private Integer cashDispenser = 10;
    static private String currentAccountNumber;
    static ATMState state;

    public static void main(String[] args) {
        bankService = new BankService();
        inputService = new InputService();
        startATM();
    }

    private static void startATM() {
        state = ATMState.Login;
        while (true) {
            try {
                OutputService.printBreak();
                switch (state) {
                    case Login:
                        UserCredentials credentials = inputService.readCredentials();
                        currentAccountNumber = bankService.login(credentials);
                        OutputService.welcome(bankService.getAccountUserName(currentAccountNumber));
                        state = ATMState.ChooseAction;
                        break;
                    case ChooseAction:
                        OutputService.presentOptions();
                        state = selectOption(inputService.readOption());
                        break;
                    case CheckBalance:
                        Integer balance = bankService.getAccountBalance(currentAccountNumber);
                        OutputService.accountBalance(balance);
                        state = ATMState.ChooseAction;
                        break;
                    case Deposit:
                        OutputService.askDepositAmount();
                        Integer depositAmount = inputService.readDepositAmount();
                        bankService.deposit(currentAccountNumber, depositAmount);
                        OutputService.successfulDeposit(depositAmount, bankService.getAccountBalance(currentAccountNumber));
                        state = ATMState.ChooseAction;
                        break;
                    case Withdraw:
                        OutputService.askWithdrawAmount();
                        Integer withdrawAmount = inputService.readWithdrawAmount();
                        bankService.checkWithdraw(currentAccountNumber, withdrawAmount);
                        checkATMFunds(withdrawAmount);
                        bankService.withdraw(currentAccountNumber, withdrawAmount);
                        withdrawATMFunds(withdrawAmount);
                        OutputService.successfulWithdrawal(withdrawAmount, bankService.getAccountBalance(currentAccountNumber));
                        state = ATMState.ChooseAction;
                        break;
                    case Logout:
                        OutputService.goodbye();
                        currentAccountNumber = null;
                        state = ATMState.Login;
                        break;
                }
            } catch (RuntimeException e) {
                OutputService.error(e.toString());

                // if there is an error during a deposit or a withdraw operation, take the user back to the main menu
                if (state == ATMState.Deposit | state == ATMState.Withdraw) {
                    state = ATMState.ChooseAction;
                }
            }
        }
    }

    private static ATMState selectOption(Integer option) {
        switch (option) {
            case 1:
                return ATMState.CheckBalance;
            case 2:
                return ATMState.Deposit;
            case 3:
                return ATMState.Withdraw;
            case 4:
                return ATMState.Logout;
        }

        return null;
    }

    private static void checkATMFunds(Integer withdrawAmount) throws InsufficientFundsException {
        Integer billsNeeded = withdrawAmount / 20;

        if (billsNeeded > cashDispenser) {
            throw new InsufficientFundsException("The ATM doesn't have enough bills for this withdrawal.\nYou can withdraw a maximum amount of $" + cashDispenser * 20);
        }
    }

    private static void withdrawATMFunds(Integer withdrawAmount) {
        Integer billsNeeded = withdrawAmount / 20;

        cashDispenser -= billsNeeded;
    }
}
