package com.deepak.jpa_mappings.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address address;
    private String firstName;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", address=" + address +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
