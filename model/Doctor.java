

package com.alliswell.hms.model;

import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	private String name;
    private String email;
    private String password;
    private String specialization;

    public Doctor() {}
    public Doctor(String name, String email, String password, String specialization) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.specialization = specialization;
    }

    // Getters and Setters
    // ...
}
