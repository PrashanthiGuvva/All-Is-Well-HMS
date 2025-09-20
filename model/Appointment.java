package com.alliswell.hms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne
    private Doctor doctor;

    public Appointment(Long id, Doctor doctor, Patient patient, LocalDateTime appointmentTime, String status) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}
	@ManyToOne
    private Patient patient;

    private LocalDateTime appointmentTime;
    private String status; // BOOKED, COMPLETED, CANCELLED

    // constructors, getters, setters
}

