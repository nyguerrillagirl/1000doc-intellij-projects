package com.brainycode.abstractdocument;

public interface HasDuration {
    String DURATION = "durationSeconds";
    default Integer getDurationSeconds() {
        return (Integer) ((Document) this).get(DURATION);
    }
}
