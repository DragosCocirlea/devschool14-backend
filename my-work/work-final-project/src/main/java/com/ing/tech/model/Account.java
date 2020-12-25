package com.ing.tech.model;

import com.ing.tech.exceptions.InsufficientBalanceException;
import com.ing.tech.exceptions.InvalidAmountException;
import com.ing.tech.model.dto.AccountInternalRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity(name = "account")
@NoArgsConstructor
public class Account {

    @Id
    private String accountNumber;

    private Double balance;

    @ManyToOne
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private User owner;

    public Account(AccountInternalRequestDTO accountInternalRequestDTO) {
        this.accountNumber = accountInternalRequestDTO.getAccountNumber();
        this.balance = accountInternalRequestDTO.getBalance();
        this.owner = accountInternalRequestDTO.getOwner();
    }

    public void transferFundsFrom(Double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException();
        }

        if (this.balance < amount) {
            throw new InsufficientBalanceException();
        }

        this.balance -= amount;
    }

    public void transferFundsTo(double amount) {
        this.balance += amount;
    }
}
