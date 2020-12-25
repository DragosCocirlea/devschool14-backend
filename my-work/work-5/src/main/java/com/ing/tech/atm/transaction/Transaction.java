package com.ing.tech.atm.transaction;


import com.ing.tech.atm.Account;

public interface Transaction {

    void execute(Account account, double amount);

}
