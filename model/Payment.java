package com.alliswell.hms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public LocalDateTime getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@ManyToOne
    private Patient patient;

    public Payment(Long id, Patient patient, Double amount, String method, LocalDateTime paidAt, String note) {
		super();
		this.id = id;
		this.patient = patient;
		this.amount = amount;
		this.method = method;
		this.paidAt = paidAt;
		this.note = note;
	}
	private Double amount;
    private String method; // CARD, UPI, CASH (mock)
    private LocalDateTime paidAt;
    private String note;

    // constructors, getters, setters
}

