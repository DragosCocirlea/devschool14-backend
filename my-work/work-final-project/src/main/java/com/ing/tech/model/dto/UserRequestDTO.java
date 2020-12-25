package com.ing.tech.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private String nationalID;
    private String password;
}
