package com.example.idempotency.service;

import com.example.idempotency.entity.Payment;
import com.example.idempotency.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment createPayment(String description) {
        Payment payment = new Payment(description);
        return repo.save(payment);
    }
}
