package com.alliswell.hms.Service;

import com.alliswell.hms.model.Insurance;
import com.alliswell.hms.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepo;

    public List<Insurance> getAllInsurances() {
        return insuranceRepo.findAll();
    }
}
