package com.alliswell.hms.Service;


import com.alliswell.hms.model.Payment;
import com.alliswell.hms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    public Payment makePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public List<Payment> getPaymentsByPatient(Long patientId) {
        return paymentRepo.findByPatientId(patientId);
    }
}

