package com.deepak.jpa_mappings.repository;

import com.deepak.jpa_mappings.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
