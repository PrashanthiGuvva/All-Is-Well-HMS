package com.alliswell.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliswell.hms.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Find appointments by doctor name
    List<Appointment> findByDoctorName(String doctorName);

    // Find appointments for a patient
    List<Appointment> findByPatientId(Long patientId);

    // Find appointments by department
    List<Appointment> findByDepartment(String department);

    // Find appointments between dates
    List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end);
}
