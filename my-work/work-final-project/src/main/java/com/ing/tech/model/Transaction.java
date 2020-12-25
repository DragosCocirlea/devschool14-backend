package com.ing.tech.model;

import com.ing.tech.model.dto.TransactionInternalRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "transaction")
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp timestamp;
    private Double amount;

    @ManyToOne
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Account fromAccount;


    @ManyToOne
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Account toAccount;

    public Transaction(TransactionInternalRequestDTO transactionInternalRequestDTO) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.amount = transactionInternalRequestDTO.getAmount();
        this.fromAccount = transactionInternalRequestDTO.getFromAccount();
        this.toAccount = transactionInternalRequestDTO.getToAccount();
    }
}
