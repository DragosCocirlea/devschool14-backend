package com.ing.tech.model.dto;

import lombok.Data;

@Data
public class TransactionHistoryRequestDTO {

    private String nationalID;
    private String password;
    private String accountNumber;
}
