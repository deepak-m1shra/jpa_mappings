package com.deepak.jpa_mappings.repository;

import com.deepak.jpa_mappings.entities.ResearchProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchProjectRepository extends JpaRepository<ResearchProject, Long> {
}