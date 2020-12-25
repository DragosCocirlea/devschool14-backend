package com.ing.tech.repository;

import com.ing.tech.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project getByName(String name);


}
