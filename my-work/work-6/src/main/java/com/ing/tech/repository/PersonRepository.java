package com.ing.tech.repository;

import com.ing.tech.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getByFirstName(String firstName);
    Optional<Person> findById(Long id);
    void deleteById(Long id);
    Set<Person> getByTeamId(Long teamId);
//    Set<Person> getAllPeople();
}
