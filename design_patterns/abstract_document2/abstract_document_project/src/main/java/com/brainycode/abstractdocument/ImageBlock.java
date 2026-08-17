package com.brainycode.abstractdocument;

import java.util.Map;

public class ImageBlock extends AbstractDocument implements
        HasDimensions, HasImageFormat {


    protected ImageBlock(Map<String, Object> properties) {
        super(properties);
    }
}
