package com.alliswell.hms.Service;

import com.alliswell.hms.model.Doctor;
import com.alliswell.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepo;

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepo.findById(id).orElse(null);
    }
}
