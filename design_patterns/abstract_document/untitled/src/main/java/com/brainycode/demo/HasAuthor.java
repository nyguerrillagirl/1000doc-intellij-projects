package com.brainycode.demo;

public interface HasAuthor {
    String AUTHOR = "author";

    default String getAuthor() {
        return (String) ((Document) this).get(AUTHOR);
    }
}
