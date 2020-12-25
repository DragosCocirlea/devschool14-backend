package com.ing.tech.model.dto;


import com.ing.tech.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonResponseDTO {

    private String firstName;
    private String lastName;
    private String password;

    public PersonResponseDTO(Person p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.password = p.getPassword();
    }
}
