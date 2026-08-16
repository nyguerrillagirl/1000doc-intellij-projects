package com.brainycode.demo;

public interface HasTags {
    String TAGS = "tags";

    @SuppressWarnings("unchecked")
    default java.util.List<String> getTags() {
        return (java.util.List<String>) ((Document) this).get(TAGS);
    }
}
