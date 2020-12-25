package com.ing.tech.model.dto;

import com.ing.tech.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionInternalRequestDTO {

    private double amount;
    private Account fromAccount;
    private Account toAccount;
}
