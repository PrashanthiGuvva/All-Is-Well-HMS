package com.alliswell.hms.Service;



import com.alliswell.hms.model.Patient;
import com.alliswell.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public List<Patient> getPatientsByDoctorId(Long doctorId) {
        // Implement logic if appointments are tracked (join with Appointment)
        return patientRepo.findAll(); // simple placeholder
    }

    public Patient getPatientById(Long id) {
        return patientRepo.findById(id).orElse(null);
    }
}
