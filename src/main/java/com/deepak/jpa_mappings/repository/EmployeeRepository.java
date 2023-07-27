package com.deepak.jpa_mappings.repository;

import com.deepak.jpa_mappings.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
