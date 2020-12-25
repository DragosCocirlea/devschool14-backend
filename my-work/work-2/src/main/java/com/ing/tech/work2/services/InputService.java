package com.ing.tech.work2.services;

import com.ing.tech.work2.data.UserCredentials;
import com.ing.tech.work2.exceptions.InvalidCredentialsException;
import com.ing.tech.work2.exceptions.InvalidOptionException;
import com.ing.tech.work2.exceptions.InvalidDepositException;

import java.util.Scanner;

public class InputService {

    private Scanner scanner;

    public InputService() {
        this.scanner = new Scanner(System.in);
    }

    public UserCredentials readCredentials() throws InvalidCredentialsException{
        // get account number
        OutputService.askAccountNumber();
        String accountNumber = scanner.nextLine();
        if (accountNumber.length() != 9) {
            throw new InvalidCredentialsException("A valid account number should have 9 alphanumeric characters.");
        }

        // get pin
        OutputService.askAccountPin();
        String accountPin = scanner.nextLine();
        if (!accountPin.matches("\\d+") | accountPin.length() != 4) {
            throw new InvalidCredentialsException("A valid pin should have 4 numeric characters.");
        }

        return new UserCredentials(accountNumber, accountPin);
    }

    public Integer readOption() throws InvalidOptionException {
        Integer option;

        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidOptionException("Please select one of the four options. Thank you!");
        }

        if (option < 1 | option > 4) {
            throw new InvalidOptionException("Please select one of the four options. Thank you!");
        }

        return option;
    }

    public Integer readDepositAmount() throws InvalidDepositException {
        Integer depositAmount;

        try {
            depositAmount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidDepositException("Please input a number as the deposited sum. Thank you!");
        }

        if (depositAmount < 0) {
            throw new InvalidDepositException("You cannot deposit a negative amount of money.");
        }

        if (depositAmount == 0) {
            throw new InvalidDepositException("You cannot deposit nothing.");
        }

        return depositAmount;
    }

    public Integer readWithdrawAmount() throws InvalidOptionException {
        Integer withdrawOption;

        try {
            withdrawOption = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidOptionException("Please select one of the five options. Thank you!");
        }

        if (withdrawOption < 1 | withdrawOption > 5) {
            throw new InvalidOptionException("Please select one of the five options. Thank you!");
        }

        return withdrawOptionToSum(withdrawOption);
    }

    private Integer withdrawOptionToSum(Integer option) {
        switch (option) {
            case 1:
                return 20;
            case 2:
                return 40;
            case 3:
                return 60;
            case 4:
                return 100;
            case 5:
                return 200;
            default:
                return 0;
        }
    }
}
