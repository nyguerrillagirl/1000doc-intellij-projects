package com.brainycode.abstractdocument;

public interface HasImageFormat {
    String FORMAT = "format";
    default String getFormat() {
        return (String) ((Document) this).get(FORMAT);
    }
}
