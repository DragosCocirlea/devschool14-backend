package com.ing.tech.work2.data;

import com.ing.tech.work2.exceptions.InsufficientFundsException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Getter
    private String accountNumber;

    private String pin;

    @Getter
    private String name;

    @Getter
    private Integer balance;

    public boolean checkPin(String pinInput) {
        return pinInput.equals(this.pin);
    }

    public void deposit(Integer amount) {
        this.balance += amount;
    }

    public void withdraw(Integer amount) throws InsufficientFundsException {

        if (amount > this.balance) {
            throw new InsufficientFundsException("You do not have enough funds for this operation.");
        }

        this.balance -= amount;
    }

    public boolean isWithdrawPossible(Integer amount) {
        return amount < this.balance;
    }
}
