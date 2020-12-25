package com.ing.tech;

import com.ing.tech.aspect.BusinessLogic;
import com.ing.tech.model.Person;
import com.ing.tech.model.Project;
import com.ing.tech.model.Team;
import com.ing.tech.repository.PersonRepository;
import com.ing.tech.repository.ProjectRepository;
import com.ing.tech.service.PersonService;
import com.ing.tech.service.ProjectService;
import com.ing.tech.service.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final BusinessLogic businessLogic;
    private PersonService personService;
    private TeamService teamService;
    private ProjectService projectService;

    public Main(BusinessLogic businessLogic, PersonService personService, TeamService teamService, ProjectService projectService) {
        this.businessLogic = businessLogic;
        this.personService = personService;
        this.teamService = teamService;
        this.projectService = projectService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
//        businessLogic.transferMoney();


//        Project pr = new Project("AOSP", "Java");
//        projectService.save(pr);
//
//
//        Team t = new Team("Pisicile salbatice");
//        t.getProjects().add(pr);
//        teamService.save(t);
//
//        Person p1 = new Person("Gigi", "Dan", "pass");
//        p1.setTeam(t);
//        personService.save(p1);
//
//        Person p2 = new Person("Giga", "Dan", "pass");
//        p2.setTeam(t);
//        personService.save(p2);
//
//        Team savedTeam = teamService.getTeamByName("Pisicile salbatice");
//        System.out.println(savedTeam);
//
//        System.out.println(projectService.getProjectByName("AOSP"));
//
//        System.out.println(personService.getPersonByTeamId(t.getId()));
    }
}
