package com.brainycode.abstractdocument;

public interface HasText {
    String TEXT = "text";
    default String getText() {
        return (String) ((Document) this).get(TEXT);
    }
}

