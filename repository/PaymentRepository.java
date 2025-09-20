package com.alliswell.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliswell.hms.model.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Find payments by method (Cash, UPI, Card)
    List<Payment> findByMethod(String method);

    // Find payments by status (true = Paid, false = Pending)
    List<Payment> findByStatus(boolean status);

    // Find payments greater than a certain amount
    List<Payment> findByAmountGreaterThan(double amount);
}
