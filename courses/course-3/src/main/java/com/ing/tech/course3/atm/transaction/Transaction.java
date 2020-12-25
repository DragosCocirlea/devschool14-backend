package com.ing.tech.course3.atm.transaction;

import com.ing.tech.course3.atm.Account;

public interface Transaction {

    void execute(Account account, double amount);

}
