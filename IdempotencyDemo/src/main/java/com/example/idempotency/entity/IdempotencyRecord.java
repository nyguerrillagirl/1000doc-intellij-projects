package com.example.idempotency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "idempotency_keys")
public class IdempotencyRecord {

    @Id
    private String id;

    @Lob
    private String responseBody;

    private int statusCode;

    private Instant createdAt = Instant.now();

    public IdempotencyRecord() {}

    public IdempotencyRecord(String id, int statusCode, String responseBody) {
        this.id = id;
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getResponseBody() { return responseBody; }
    public void setResponseBody(String responseBody) { this.responseBody = responseBody; }

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
