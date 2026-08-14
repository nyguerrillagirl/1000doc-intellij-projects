package com.brainycode.demo.asyncwebfluxdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
public class AsyncFetchReactive implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AsyncFetchReactive.class, args);
    }

    @Override
    public void run(String... args) {
        WebClient client = WebClient.create();

        List<String> urls = List.of(
                "https://python.org",
                "https://realpython.com",
                "https://google.com",
                "https://example.com",
                "https://brainycode.com"
        );

        Flux.fromIterable(urls)
                .flatMap(url ->
                        client.get()
                                .uri(url)
                                .retrieve()
                                .bodyToMono(String.class)
                                .map(body -> url + " => " + body.length() + " chars")
                                .onErrorReturn("Failed to fetch " + url)
                )
                .doOnNext(System.out::println)
                .blockLast();   // Wait for all to finish


    }
}
