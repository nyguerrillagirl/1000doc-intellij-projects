package com.example.idempotency.filter;

import com.example.idempotency.entity.IdempotencyRecord;
import com.example.idempotency.service.IdempotencyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


public class IdempotencyFilter extends OncePerRequestFilter {

    private final IdempotencyService idempotencyService;

    public IdempotencyFilter(IdempotencyService idempotencyService) {
        this.idempotencyService = idempotencyService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String key = request.getHeader("Idempotency-Key");

        if (key == null) {
            filterChain.doFilter(request, response);
            return;
        }

        Optional<IdempotencyRecord> existing = idempotencyService.getRecord(key);

        if (existing.isPresent()) {
            IdempotencyRecord record = existing.get();
            response.setStatus(record.getStatusCode());
            response.getWriter().write(record.getResponseBody());
            return;
        }

        ContentCachingResponseWrapper wrapped = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(request, wrapped);

        String body = new String(wrapped.getContentAsByteArray(), StandardCharsets.UTF_8);
        idempotencyService.saveRecord(key, wrapped.getStatus(), body);

        wrapped.copyBodyToResponse();
    }
}
