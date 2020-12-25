package com.ing.tech.work2.data;

public class ATMStates {
    public enum ATMState {
        Login,
        ChooseAction,
        CheckBalance,
        Deposit,
        Withdraw,
        Logout
    }
}
