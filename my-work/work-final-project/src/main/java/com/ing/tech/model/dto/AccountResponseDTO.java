package com.ing.tech.model.dto;

import com.ing.tech.model.Account;
import lombok.Data;

@Data
public class AccountResponseDTO {

    private String accountNumber;
    private Double balance;

    public AccountResponseDTO(Account account) {
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getBalance();
    }
}
