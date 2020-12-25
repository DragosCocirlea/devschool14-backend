package com.ing.tech.controller;

import com.ing.tech.exceptions.AccountNotFoundException;
import com.ing.tech.exceptions.SameAccountsException;
import com.ing.tech.model.Account;
import com.ing.tech.model.User;
import com.ing.tech.model.dto.*;
import com.ing.tech.service.AccountService;
import com.ing.tech.service.TransactionService;
import com.ing.tech.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
@Slf4j
public class TransactionController {

    TransactionService transactionService;
    UserService userService;
    AccountService accountService;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> makeTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        // check user credentials
        User owner = userService.checkCredentials(transactionRequestDTO.getNationalID(), transactionRequestDTO.getPassword());

        // check user actually owns the account from where funds are transferred
        Optional<Account> fromAccount = owner.getAccounts().stream().filter(acc -> acc.getAccountNumber().equals(transactionRequestDTO.getFromAccountNumber())).findFirst();
        fromAccount.orElseThrow(AccountNotFoundException::new);

        // check the receiving account exists
        Optional<Account> toAccount = accountService.getAccountByNumber(transactionRequestDTO.getToAccountNumber());
        toAccount.orElseThrow(AccountNotFoundException::new);

        // check the accounts are not the same
        if (fromAccount.equals(toAccount)) {
            throw new SameAccountsException();
        }

        // make the transaction
        TransactionInternalRequestDTO transactionInternalRequestDTO = new TransactionInternalRequestDTO(transactionRequestDTO.getAmount(), fromAccount.get(), toAccount.get());
        TransactionResponseDTO transactionResponseDTO = transactionService.makeTransaction(transactionInternalRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponseDTO);
    }

    @GetMapping(path = "/inbound")
    public ResponseEntity<List<TransactionResponseDTO>> getInboundTransactions(@RequestBody TransactionHistoryRequestDTO transactionHistoryRequestDTO) {
        // check user credentials
        User owner = userService.checkCredentials(transactionHistoryRequestDTO.getNationalID(), transactionHistoryRequestDTO.getPassword());

        // check user actually owns the account from where funds are transferred
        Optional<Account> account = owner.getAccounts().stream().filter(acc -> acc.getAccountNumber().equals(transactionHistoryRequestDTO.getAccountNumber())).findFirst();
        account.orElseThrow(AccountNotFoundException::new);

        // return all transactions associated with the account
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.getInboundTransactions(account.get()));
    }

    @GetMapping(path = "/outbound")
    public ResponseEntity<List<TransactionResponseDTO>> getOutboundTransactions(@RequestBody TransactionHistoryRequestDTO transactionHistoryRequestDTO) {
        // check user credentials
        User owner = userService.checkCredentials(transactionHistoryRequestDTO.getNationalID(), transactionHistoryRequestDTO.getPassword());

        // check user actually owns the account from where funds are transferred
        Optional<Account> account = owner.getAccounts().stream().filter(acc -> acc.getAccountNumber().equals(transactionHistoryRequestDTO.getAccountNumber())).findFirst();
        account.orElseThrow(AccountNotFoundException::new);

        // return all transactions associated with the account
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.getOutboundTransactions(account.get()));
    }

    @GetMapping()
    public ResponseEntity<TransactionHistoryResponseDTO> getAllTransactions(@RequestBody TransactionHistoryRequestDTO transactionHistoryRequestDTO) {
        // check user credentials
        User owner = userService.checkCredentials(transactionHistoryRequestDTO.getNationalID(), transactionHistoryRequestDTO.getPassword());

        // check user actually owns the account from where funds are transferred
        Optional<Account> account = owner.getAccounts().stream().filter(acc -> acc.getAccountNumber().equals(transactionHistoryRequestDTO.getAccountNumber())).findFirst();
        account.orElseThrow(AccountNotFoundException::new);

        // return all transactions associated with the account
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.getAllTransactions(account.get()));
    }
}
