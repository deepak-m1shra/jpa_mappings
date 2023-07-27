package com.deepak.jpa_mappings.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ResearchProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
//    private String description;
//    private Timestamp startDate;
//    private Timestamp tentativeEndDate;
//    private Timestamp actualEndDate;

    @ManyToMany
    @JoinTable(
            name = "project_professor_id",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private Set<Professor> professors = new HashSet<>();

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }
}
