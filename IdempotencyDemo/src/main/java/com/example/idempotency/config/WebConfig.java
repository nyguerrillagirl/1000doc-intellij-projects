package com.example.idempotency.config;

import com.example.idempotency.filter.IdempotencyFilter;
import com.example.idempotency.service.IdempotencyService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public IdempotencyFilter idempotencyFilterBean(IdempotencyService service) {
        return new IdempotencyFilter(service);
    }

    @Bean
    public FilterRegistrationBean<IdempotencyFilter> idempotencyFilter(IdempotencyFilter filter) {
        FilterRegistrationBean<IdempotencyFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
