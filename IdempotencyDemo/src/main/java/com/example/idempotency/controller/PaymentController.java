package com.example.idempotency.controller;

import com.example.idempotency.entity.Payment;
import com.example.idempotency.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody String description) {
        Payment payment = service.createPayment(description);
        return ResponseEntity.ok("Payment created: " + payment.getId());
    }
}
