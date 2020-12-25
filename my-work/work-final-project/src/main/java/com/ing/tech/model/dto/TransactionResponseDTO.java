package com.ing.tech.model.dto;

import com.ing.tech.model.Transaction;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionResponseDTO {

    private Double amount;
    private String fromAccount;
    private String toAccount;
    private Timestamp timestamp;

    public TransactionResponseDTO(Transaction transaction) {
        this.amount = transaction.getAmount();
        this.fromAccount = transaction.getFromAccount().getAccountNumber();
        this.toAccount = transaction.getToAccount().getAccountNumber();
        this.timestamp = transaction.getTimestamp();
    }
}
