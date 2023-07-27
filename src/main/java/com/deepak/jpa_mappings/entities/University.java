package com.deepak.jpa_mappings.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String universityName;

    @OneToMany(mappedBy = "university")
    private List<UniversityStudent> universityStudents = new ArrayList<>();

    void addStudent(UniversityStudent s) {
        universityStudents.add(s);
    }

    public University(String name) {
        this.universityName = name;
    }
}
