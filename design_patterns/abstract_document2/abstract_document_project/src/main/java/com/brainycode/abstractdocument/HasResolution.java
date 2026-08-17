package com.brainycode.abstractdocument;

public interface HasResolution {
    String RESOLUTION = "resolution";
    default String getResolution() {
        return (String) ((Document) this).get(RESOLUTION);
    }
}
