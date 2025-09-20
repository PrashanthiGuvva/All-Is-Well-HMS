package com.alliswell.hms.Service;


import com.alliswell.hms.model.Patient;
import com.alliswell.hms.model.Doctor;
import com.alliswell.hms.repository.PatientRepository;
import com.alliswell.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    // Patient
    public Patient registerPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public Patient loginPatient(String email, String password) {
        return patientRepo.findByEmail(email)
                .filter(p -> p.getPassword().equals(password))
                .orElse(null);
    }

    // Doctor
    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public Doctor loginDoctor(String email, String password) {
        return doctorRepo.findByEmail(email)
                .filter(d -> d.getPassword().equals(password))
                .orElse(null);
    }
}
