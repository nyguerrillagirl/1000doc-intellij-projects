package com.brainycode.abstractdocument;

import java.util.*;

public class CMSDemo {

    public static void main(String[] args) {

        // Paragraph
        Map<String, Object> paragraph = Map.of(
                "text", "Intro to Java..."
        );

        // Images for gallery
        Map<String, Object> galleryImg1 = Map.of(
                "width", 800,
                "height", 600,
                "format", "jpg"
        );

        Map<String, Object> galleryImg2 = Map.of(
                "width", 1024,
                "height", 768,
                "format", "png"
        );

        // Gallery block
        Map<String, Object> gallery = new HashMap<>();
        gallery.put("title", "Java Versions Over Time");
        gallery.put("children", List.of(galleryImg1, galleryImg2));

        // Transcript block
        Map<String, Object> transcript = Map.of(
                "text", "Welcome to the video...",
                "language", "en"
        );

        // Video block
        Map<String, Object> video = new HashMap<>();
        video.put("durationSeconds", 360);
        video.put("resolution", "1080p");
        video.put("children", List.of(transcript));

        // Image block
        Map<String, Object> image = Map.of(
                "width", 1920,
                "height", 1080,
                "format", "png",
                "caption", "Java architecture diagram"
        );

        // Article with children
        Map<String, Object> articleProps = new HashMap<>();
        articleProps.put("author", "Alice");
        articleProps.put("createdDate", "2024-01-01");
        articleProps.put("tags", List.of("tech", "java"));
        articleProps.put("children", List.of(paragraph, image, video, gallery));

        Article article = new Article(articleProps);

        // Print article metadata
        System.out.println("Article by " + article.getAuthor());
        System.out.println("Created: " + article.getCreatedDate());
        System.out.println("Tags: " + article.getTags());

        System.out.println("\n=== Article Blocks ===");

        // Traverse children
        article.children("children", CMSDemo::constructBlock)
                .forEach(block -> {
                    System.out.println("Block: " + block.getClass().getSimpleName());
                    System.out.println(block);
                    System.out.println();
                });
    }

    // Factory method to detect block type based on keys
    private static AbstractDocument constructBlock(Map<String, Object> props) {

        if (props.containsKey("text") && props.containsKey("language")) {
            return new TranscriptBlock(props);
        }
        if (props.containsKey("text")) {
            return new ParagraphBlock(props);
        }
        if (props.containsKey("durationSeconds")) {
            return new VideoBlock(props);
        }
        if (props.containsKey("width") && props.containsKey("height")) {
            return new ImageBlock(props);
        }
        if (props.containsKey("title")) {
            return new GalleryBlock(props);
        }

        throw new IllegalArgumentException("Unknown block type: " + props);
    }
}
