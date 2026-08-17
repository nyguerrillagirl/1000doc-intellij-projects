package com.brainycode.abstractdocument;

public interface HasLanguage {
    String LANGUAGE = "language";
    default String getLanguage() {
        return (String) ((Document) this).get(LANGUAGE);
    }
}

