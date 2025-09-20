package com.alliswell.hms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Receipt {
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToOne
    private Patient patient;

    public Receipt(Long id, Patient patient, Double amount, LocalDateTime createdAt, String content) {
		super();
		this.id = id;
		this.patient = patient;
		this.amount = amount;
		this.createdAt = createdAt;
		this.content = content;
	}
	private Double amount;
    private LocalDateTime createdAt;
    private String content; // plain text or JSON summary we can download

    // getters, setters
}

