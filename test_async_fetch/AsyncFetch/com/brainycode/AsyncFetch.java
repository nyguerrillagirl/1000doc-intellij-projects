package com.brainycode;

import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AsyncFetch {

    private static CompletableFuture<Void> fetchAsync(HttpClient client, String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(body -> {
                    System.out.println(url + " => " + body.length() + " chars");
                })
                .exceptionally(e -> {
                    System.out.println("Failed fo fetch " + url + ": " + e.getMessage());
                    return null;
                });
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        List<String> urls = List.of(
                "https://python.org",
                "https://realpython.com",
                "https://google.com",
                "https://example.com",
                "https://brainycode.com"
        );

        // Create a CompletetableFuture for each URL
        List<CompletableFuture<Void>> futures = urls.stream()
                .map(url -> fetchAsync(client, url))
                .toList();

        // Wait for all to finish
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }


}
