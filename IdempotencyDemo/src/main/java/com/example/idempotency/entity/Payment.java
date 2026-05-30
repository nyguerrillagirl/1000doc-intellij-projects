package com.example.idempotency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;

    private String description;

    public Payment() {}

    public Payment(String description) {
        this.description = description;
    }

    public UUID getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
