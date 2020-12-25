package com.ing.tech.service;

import com.ing.tech.model.Team;
import com.ing.tech.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeamByName(String name) {
        return teamRepository.getByName(name);
    }
}
