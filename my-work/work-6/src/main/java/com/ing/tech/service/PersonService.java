package com.ing.tech.service;

import com.ing.tech.PersonNotFoundException;
import com.ing.tech.model.Person;
import com.ing.tech.model.dto.PersonRequestDTO;
import com.ing.tech.model.dto.PersonResponseDTO;
import com.ing.tech.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonResponseDTO save(PersonRequestDTO p) {
        Person person = new Person(p);
        return new PersonResponseDTO(personRepository.save(person));
    }

    public  PersonResponseDTO getPersonByFirstName(String firstName) {
                Person p = personRepository.getByFirstName(firstName);
                return new PersonResponseDTO(p);
    }

    public Set<PersonResponseDTO> getPersonByTeamId(Long teamId) {
        Set<Person> people =  personRepository.getByTeamId(teamId);
        Set<PersonResponseDTO> peopleResponseDTO = new HashSet<>();

        people.forEach((p) -> peopleResponseDTO.add(new PersonResponseDTO(p)));

        return  peopleResponseDTO;
    }

    public PersonResponseDTO findById(Long id) {
        Optional<Person> person = this.personRepository.findById(id);
        return new PersonResponseDTO(person.orElseThrow(PersonNotFoundException::new));
    }

    public void deleteById(Long id) {
        Person person = this.personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        personRepository.deleteById(id);
    }

    public Set<PersonResponseDTO> getAllPeople() {
        return personRepository.findAll().stream().map(PersonResponseDTO::new).collect(Collectors.toSet());
    }
}
