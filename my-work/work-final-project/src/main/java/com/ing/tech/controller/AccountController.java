package com.ing.tech.controller;

import com.ing.tech.model.User;
import com.ing.tech.model.dto.AccountInternalRequestDTO;
import com.ing.tech.model.dto.AccountRequestDTO;
import com.ing.tech.model.dto.AccountResponseDTO;
import com.ing.tech.service.AccountService;
import com.ing.tech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        User owner = userService.checkCredentials(accountRequestDTO.getNationalID(), accountRequestDTO.getPassword());

        AccountInternalRequestDTO req = new AccountInternalRequestDTO(accountRequestDTO.getAccountNumber(), accountRequestDTO.getBalance(), owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(req));
    }

    @GetMapping
    public ResponseEntity<Set<AccountResponseDTO>> getAllAccounts(@RequestBody AccountRequestDTO accountRequestDTO) {
        User owner = userService.checkCredentials(accountRequestDTO.getNationalID(), accountRequestDTO.getPassword());

        return ResponseEntity.status(HttpStatus.OK).body(accountService.getUserAccounts(owner));
    }
}
