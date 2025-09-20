package com.alliswell.hms.model;

import jakarta.persistence.*;

@Entity
public class Insurance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getCoverageDetails() {
		return coverageDetails;
	}
	public void setCoverageDetails(String coverageDetails) {
		this.coverageDetails = coverageDetails;
	}
	private String providerName;
    public Insurance(Long id, String providerName, String policyNumber, String coverageDetails) {
		super();
		this.id = id;
		this.providerName = providerName;
		this.policyNumber = policyNumber;
		this.coverageDetails = coverageDetails;
	}
	private String policyNumber;
    private String coverageDetails;
    // constructors, getters, setters
}

