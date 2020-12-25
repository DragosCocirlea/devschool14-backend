package com.ing.tech.service;

import com.ing.tech.model.Project;
import com.ing.tech.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project p) {
        return projectRepository.save(p);
    }

    public Project getProjectByName(String name) {
        return projectRepository.getByName(name);
    }
}
