package com.alliswell.hms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliswell.hms.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Find by email
    Optional<Patient> findByEmail(String email);

    // Find all patients with a given age
    List<Patient> findByAge(int age);

    // Find patients by gender
    List<Patient> findByGender(String gender);

    // Find patients whose name contains keyword
    List<Patient> findByNameContainingIgnoreCase(String keyword);
}
