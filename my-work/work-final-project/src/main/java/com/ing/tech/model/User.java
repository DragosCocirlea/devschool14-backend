package com.ing.tech.model;

import com.ing.tech.model.dto.UserRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "user")
@NoArgsConstructor
public class User {
    @Id
    private String nationalID;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private byte[] hashedPassword;

    @OneToMany(
            mappedBy = "owner",
            fetch = FetchType.EAGER
    )
    @ToString.Exclude @EqualsAndHashCode.Exclude
    Set<Account> accounts = new HashSet<>();

    public User(UserRequestDTO userRequestDTO) {
        this.firstName = userRequestDTO.getFirstName();
        this.lastName = userRequestDTO.getLastName();
        this.address = userRequestDTO.getAddress();
        this.email = userRequestDTO.getEmail();
        this.phoneNumber = userRequestDTO.getPhoneNumber();
        this.nationalID = userRequestDTO.getNationalID();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            this.hashedPassword = digest.digest(userRequestDTO.getPassword().getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
