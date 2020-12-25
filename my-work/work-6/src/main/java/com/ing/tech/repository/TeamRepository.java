package com.ing.tech.repository;

import com.ing.tech.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team getByName(String name);

}
