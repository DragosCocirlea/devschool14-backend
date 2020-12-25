package com.ing.tech.model.dto;

import com.ing.tech.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountInternalRequestDTO {

    private String accountNumber;
    private Double balance;
    private User owner;
}
