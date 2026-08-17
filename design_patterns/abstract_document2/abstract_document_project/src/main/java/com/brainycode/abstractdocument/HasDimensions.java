package com.brainycode.abstractdocument;

public interface HasDimensions {
    String WIDTH = "width";
    String HEIGHT = "height";

    default Integer getWidth() {
        return (Integer) ((Document)this).get(WIDTH);
    }

    default Integer getHeight() {
        return (Integer) ((Document)this).get(HEIGHT);
    }
}
