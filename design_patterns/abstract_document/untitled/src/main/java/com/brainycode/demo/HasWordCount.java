package com.brainycode.demo;

public interface HasWordCount {
    String WORD_COUNT = "wordCount";
    default Integer getWordCount() {
        return (Integer) ((Document) this).get(WORD_COUNT);
    }
}
