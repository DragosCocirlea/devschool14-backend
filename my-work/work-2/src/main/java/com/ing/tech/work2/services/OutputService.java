package com.ing.tech.work2.services;

public class OutputService {

    public static void askAccountNumber() {
        System.out.print("Enter account number:\n\t> ");
    }

    public static void askAccountPin() {
        System.out.print("Enter pin:\n\t> ");
    }

    public static void welcome(String name) {
        System.out.println("\nHello " + name +"! Welcome back!");
    }

    public static void presentOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("\t> ");
    }

    public static void accountBalance(Integer balance) {
        System.out.println("You balance is: $" + balance);
    }

    public static void askDepositAmount() {
        System.out.println("How much would you like to deposit?");
        System.out.print("\t> $");
    }

    public static void successfulDeposit(Integer depositAmount, Integer newBalance) {
        System.out.println("$" + depositAmount + " have been added to your account.");
        System.out.println("You new balance is: $" + newBalance);
    }

    public static void askWithdrawAmount() {
        System.out.println("How much would you like to withdraw?");
        System.out.println("1. $20");
        System.out.println("2. $40");
        System.out.println("3. $60");
        System.out.println("4. $100");
        System.out.println("5. $200");
        System.out.print("\t> ");
    }
    public static void successfulWithdrawal(Integer withdrawAmount, Integer newBalance) {
        System.out.println("$" + withdrawAmount + " have been withdrawn from your account.");
        System.out.println("You new balance is: $" + newBalance);
    }

    public static void error(String message) {
        System.out.println("ERROR: " + message);
    }

    public static void printBreak() {
        System.out.println("\n==============================================\n");
    }

    public static void goodbye() {
        System.out.println("You are now logged out. Good bye!");
    }
}
