package com.ing.tech.repository;

import com.ing.tech.model.Account;
import com.ing.tech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Set<Account> getAllByOwner(User owner);
    Optional<Account> getByAccountNumber(String accountNumber);
}
