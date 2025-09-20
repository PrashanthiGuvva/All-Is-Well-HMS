package com.alliswell.hms.Service;



import com.alliswell.hms.model.Receipt;
import com.alliswell.hms.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepo;

    public Receipt createReceipt(Receipt receipt) {
        return receiptRepo.save(receipt);
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepo.findAll();
    }

    public List<Receipt> getReceiptsByPatient(Long patientId) {
        return receiptRepo.findByPatientId(patientId);
    }
}
