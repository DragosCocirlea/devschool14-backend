package com.ing.tech.repository;

import com.ing.tech.model.Account;
import com.ing.tech.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> getAllByFromAccount(Account account);
    List<Transaction> getAllByToAccount(Account account);
}
