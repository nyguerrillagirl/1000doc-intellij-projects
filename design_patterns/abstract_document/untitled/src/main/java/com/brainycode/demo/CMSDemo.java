package com.brainycode.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CMSDemo {
    public static void main(String[] args) {
        Map<String, Object> articleProps = Map.of(
                "author", "Alice",
                "createdDate", "2024-01-01",
                "tags", List.of("tech", "java"),
                "wordCount", 1200
        );

        Article article = new Article(new HashMap<>(articleProps));
        System.out.println("Article by " + article.getAuthor());
        System.out.println("Tags: " + article.getTags());
        System.out.println("Word count: " + article.getWordCount());


        Map<String, Object> imageProps = Map.of(
                "author", "Bob",
                "createdDate", "2024-02-10",
                "tags", List.of("design", "ui"),
                "width", 1920,
                "height", 1080,
                "format", "png"
        );

        ImageContent image = new ImageContent(new HashMap<>(imageProps));
        System.out.println("\nImage by " + image.getAuthor());
        System.out.println("Dimensions: " + image.getWidth() + "x" + image.getHeight());
        System.out.println("Format: " + image.getFormat());


        Map<String, Object> videoProps = Map.of(
                "author", "Charlie",
                "createdDate", "2024-03-05",
                "tags", List.of("tutorial", "java"),
                "durationSeconds", 360,
                "resolution", "1080p"
        );

        VideoContent video = new VideoContent(new HashMap<>(videoProps));
        System.out.println("\nVideo by " + video.getAuthor());
        System.out.println("Duration: " + video.getDurationSeconds() + " seconds");
        System.out.println("Resolution: " + video.getResolution());
    }
}
