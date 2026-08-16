package com.brainycode.demo;

public interface HasImageFormat {
    String FORMAT = "format";
    default String getFormat() {
        return (String) ((Document) this).get(FORMAT);
    }
}
