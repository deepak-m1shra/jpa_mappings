package com.deepak.jpa_mappings.repository;

import com.deepak.jpa_mappings.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}