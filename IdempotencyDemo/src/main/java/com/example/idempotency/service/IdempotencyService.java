package com.example.idempotency.service;

import com.example.idempotency.entity.IdempotencyRecord;
import com.example.idempotency.repository.IdempotencyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdempotencyService {

    private final IdempotencyRepository repo;

    public IdempotencyService(IdempotencyRepository repo) {
        this.repo = repo;
    }

    public Optional<IdempotencyRecord> getRecord(String key) {
        return repo.findById(key);
    }

    public void saveRecord(String key, int status, String body) {
        IdempotencyRecord record = new IdempotencyRecord(key, status, body);
        repo.save(record);
    }
}
