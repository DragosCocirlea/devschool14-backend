package com.ing.tech.bean;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// kinda wrapper peste bean
//@Repository -> database
//@Service -> bussiness logic
//@Controller -> cel cu care comunicam
//@Configuration
//@Component

@Service
public class PersonService {

    // option 1
//    @Autowired
    private PersonRepository personRepository;

    // option 3 -> the winner
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void printName() {
        System.out.println(personRepository.getPerson());
    }

    // option 2
//    @Autowired
//    public void setPersonRepository(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
}



