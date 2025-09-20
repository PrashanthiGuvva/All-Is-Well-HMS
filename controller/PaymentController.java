package com.alliswell.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alliswell.hms.model.Payment;
import com.alliswell.hms.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentRepository.findById(id);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment details) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setAmount(details.getAmount());
                    payment.setMethod(details.getMethod());
                    payment.setStatus(details.isStatus());
                    return paymentRepository.save(payment);
                }).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
    }
}
