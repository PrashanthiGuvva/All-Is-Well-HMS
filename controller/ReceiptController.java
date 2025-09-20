package com.alliswell.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alliswell.hms.model.Receipt;
import com.alliswell.hms.repository.ReceiptRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping
    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Receipt> getReceiptById(@PathVariable Long id) {
        return receiptRepository.findById(id);
    }

    @PostMapping
    public Receipt createReceipt(@RequestBody Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        receiptRepository.deleteById(id);
    }
}
