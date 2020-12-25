package com.ing.tech;

import com.ing.tech.service.AccountService;
import com.ing.tech.service.TransactionService;
import com.ing.tech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class Main {

    UserService userService;
    AccountService accountService;
    TransactionService transactionService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
