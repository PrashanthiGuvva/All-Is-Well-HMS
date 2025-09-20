package com.alliswell.hms.controller;


import com.alliswell.hms.model.Patient;
import com.alliswell.hms.model.Doctor;
import com.alliswell.hms.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	// Patient
    @PostMapping("/patient/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        return authService.registerPatient(patient);
    }

    @PostMapping("/patient/login")
    public Patient loginPatient(@RequestBody Patient loginData) {
        Patient p = authService.loginPatient(loginData.getEmail(), loginData.getPassword());
        if (p == null) throw new RuntimeException("Invalid credentials");
        return p;
    }

    // Doctor
    @PostMapping("/doctor/register")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return authService.registerDoctor(doctor);
    }

    @PostMapping("/doctor/login")
    public Doctor loginDoctor(@RequestBody Doctor loginData) {
        Doctor d = authService.loginDoctor(loginData.getEmail(), loginData.getPassword());
        if (d == null) throw new RuntimeException("Invalid credentials");
        return d;
    }
}
