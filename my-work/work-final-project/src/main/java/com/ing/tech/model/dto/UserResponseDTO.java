package com.ing.tech.model.dto;

import com.ing.tech.model.User;
import lombok.Data;

@Data
public class UserResponseDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private String nationalID;

    public UserResponseDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.nationalID = user.getNationalID();
    }
}
