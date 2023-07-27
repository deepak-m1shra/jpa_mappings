package com.deepak.jpa_mappings.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String details;
    @ManyToMany
    private List<Student> studentList;


}
