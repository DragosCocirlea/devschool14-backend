package com.ing.tech.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private Address address;
    private String position;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

}