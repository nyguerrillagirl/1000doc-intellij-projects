package com.brainycode.abstractdocument;

import java.util.Map;

public class ParagraphBlock extends AbstractDocument implements
    HasText {

    protected ParagraphBlock(Map<String, Object> properties) {
        super(properties);
    }
}
