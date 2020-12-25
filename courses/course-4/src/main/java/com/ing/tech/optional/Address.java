package com.ing.tech.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class Address {
    private String addressLine;
    private String city;
    private Country country;

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }
}