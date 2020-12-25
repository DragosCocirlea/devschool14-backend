package com.ing.tech.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "project")
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String technologies;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude @ToString.Exclude
    private Set<Team> teams = new HashSet<>();

    public Project(String name, String technologies) {
        this.name = name;
        this.technologies = technologies;
    }
}
