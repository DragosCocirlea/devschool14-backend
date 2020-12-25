package com.ing.tech.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRequestDTO {

    private String nationalID;
    private String password;
    private String accountNumber;
    private Double balance;
}
