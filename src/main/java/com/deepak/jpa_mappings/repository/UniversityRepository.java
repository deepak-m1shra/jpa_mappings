package com.deepak.jpa_mappings.repository;

import com.deepak.jpa_mappings.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}