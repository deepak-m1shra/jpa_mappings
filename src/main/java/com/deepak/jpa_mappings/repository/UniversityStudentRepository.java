package com.deepak.jpa_mappings.repository;

import com.deepak.jpa_mappings.entities.UniversityStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityStudentRepository extends JpaRepository<UniversityStudent, Long> {
}