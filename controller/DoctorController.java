package com.alliswell.hms.controller;

import com.alliswell.hms.model.Doctor;
import com.alliswell.hms.repository.DoctorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public List<Doctor> allDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/available")
    public List<Doctor> availableDoctors() {
        return doctorRepository.findByAvailableTrue();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable Long id) {
        return doctorRepository.findById(id);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doc) {
        return doctorRepository.save(doc);
    }
}

