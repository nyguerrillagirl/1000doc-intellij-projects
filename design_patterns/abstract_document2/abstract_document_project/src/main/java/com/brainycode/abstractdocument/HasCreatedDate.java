package com.brainycode.abstractdocument;

public interface HasCreatedDate {
    String CREATED_DATE = "createdDate";

    default String getCreatedDate() {
        return (String) ((Document) this).get(CREATED_DATE);
    }
}
