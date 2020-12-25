package com.ing.tech.model.dto;

import com.ing.tech.model.Person;
import com.ing.tech.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonRequestDTO {

    private String firstName;
    private String lastName;
    private String password;

    private Team team;


    public PersonRequestDTO(Person p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.password = p.getPassword();
    }
}
