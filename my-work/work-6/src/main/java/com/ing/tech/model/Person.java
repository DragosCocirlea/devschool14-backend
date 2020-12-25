package com.ing.tech.model;

import com.ing.tech.model.dto.PersonRequestDTO;
import com.ing.tech.model.dto.PersonResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity(name = "person")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String password;

    @ManyToOne
    @ToString.Exclude
    private Team team;

    public Person(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Person(PersonRequestDTO pr) {
        this.firstName = pr.getFirstName();
        this.lastName = pr.getLastName();
        this.password = pr.getPassword();
    }

    public Person(PersonResponseDTO pr) {
        this.firstName = pr.getFirstName();
        this.lastName = pr.getLastName();
        this.password = pr.getPassword();
    }
}
