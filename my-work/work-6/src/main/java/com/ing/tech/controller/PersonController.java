package com.ing.tech.controller;

import com.ing.tech.PersonNotFoundException;
import com.ing.tech.model.dto.PersonRequestDTO;
import com.ing.tech.model.dto.PersonResponseDTO;
import com.ing.tech.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> savePerson(@RequestBody PersonRequestDTO personRequestDTO) {

        PersonResponseDTO personResponseDTO =  personService.save(personRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personResponseDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Set<PersonResponseDTO>> getAllPeople() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPeople());
    }

}
