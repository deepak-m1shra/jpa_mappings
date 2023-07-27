package com.deepak.jpa_mappings.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class P_Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "pCopySet")
    private Set<RP_Copy> rpCopySet = new HashSet<>();
}
