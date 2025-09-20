package com.alliswell.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliswell.hms.model.Insurance;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    // Find by provider
    List<Insurance> findByProvider(String provider);

    // Find by policy number
    Optional<Insurance> findByPolicyNumber(String policyNumber);

    // Find all insurance plans for a patient
    List<Insurance> findByPatientId(Long patientId);

    // Find all insurance plans with coverage > given amount
    List<Insurance> findByCoverageAmountGreaterThan(double coverageAmount);
}
