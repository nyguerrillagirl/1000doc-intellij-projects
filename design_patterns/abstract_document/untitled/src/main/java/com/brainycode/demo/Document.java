package com.brainycode.demo;

import java.util.Map;

public class Document {
    protected final Map<String, Object> properties;

    public Document(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Object get(String key) {
        return properties.get(key);
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }
}
