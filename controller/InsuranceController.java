package com.alliswell.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alliswell.hms.model.Insurance;
import com.alliswell.hms.repository.InsuranceRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping
    public List<Insurance> getAllInsurance() {
        return insuranceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Insurance> getInsuranceById(@PathVariable Long id) {
        return insuranceRepository.findById(id);
    }

    @PostMapping
    public Insurance createInsurance(@RequestBody Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @PutMapping("/{id}")
    public Insurance updateInsurance(@PathVariable Long id, @RequestBody Insurance details) {
        return insuranceRepository.findById(id)
                .map(ins -> {
                    ins.setProvider(details.getProvider());
                    ins.setPolicyNumber(details.getPolicyNumber());
                    ins.setCoverageAmount(details.getCoverageAmount());
                    return insuranceRepository.save(ins);
                }).orElseThrow(() -> new RuntimeException("Insurance not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteInsurance(@PathVariable Long id) {
        insuranceRepository.deleteById(id);
    }
}

