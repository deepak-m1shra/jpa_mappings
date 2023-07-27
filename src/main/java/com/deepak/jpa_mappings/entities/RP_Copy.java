package com.deepak.jpa_mappings.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class RP_Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "p_rp_copy_mapping",
            joinColumns = @JoinColumn(name = "rp_copy_id"),
            inverseJoinColumns = @JoinColumn(name = "p_copy_id")
    )
    private Set<P_Copy> pCopySet = new HashSet<>();

}
