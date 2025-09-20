package com.alliswell.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliswell.hms.model.Receipt;

import java.util.Optional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    // Find receipt by receipt number
    Optional<Receipt> findByReceiptNumber(String receiptNumber);

    // Find receipt by payment ID
    Optional<Receipt> findByPaymentId(Long paymentId);
}
