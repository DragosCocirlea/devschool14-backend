package com.ing.tech.service;

import com.ing.tech.exceptions.AccountNumberAlreadyExistsException;
import com.ing.tech.model.Account;
import com.ing.tech.model.User;
import com.ing.tech.model.dto.AccountInternalRequestDTO;
import com.ing.tech.model.dto.AccountResponseDTO;
import com.ing.tech.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponseDTO createAccount(AccountInternalRequestDTO accountInternalRequestDTO) {
        // if the number is already taken, throw an error
        Optional<Account> accountOptional = accountRepository.getByAccountNumber(accountInternalRequestDTO.getAccountNumber());
        if (accountOptional.isPresent()) {
            throw new AccountNumberAlreadyExistsException();
        }

        return new AccountResponseDTO(accountRepository.save(new Account(accountInternalRequestDTO)));
    }

    public Set<AccountResponseDTO> getUserAccounts(User owner) {
        return accountRepository.getAllByOwner(owner).stream().map(AccountResponseDTO::new).collect(Collectors.toSet());
    }

    public Optional<Account> getAccountByNumber(String accountNumber) {
        return accountRepository.getByAccountNumber(accountNumber);
    }

}
