package com.deepak.jpa_mappings.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer yrsOfExperience;

    @ManyToMany(mappedBy = "professors")
    private Set<ResearchProject> researchProjects = new HashSet<>();

    public void addProject(ResearchProject project) {
        researchProjects.add(project);
    }
}
