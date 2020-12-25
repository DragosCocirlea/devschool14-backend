package com.ing.tech.repository;

import com.ing.tech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByNationalID(String nationalID);
    Optional<User> getByEmail(String email);
}
