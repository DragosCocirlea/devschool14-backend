package com.ing.tech.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionRequestDTO {

    private String nationalID;
    private String password;
    private double amount;
    private String fromAccountNumber;
    private String toAccountNumber;
}
