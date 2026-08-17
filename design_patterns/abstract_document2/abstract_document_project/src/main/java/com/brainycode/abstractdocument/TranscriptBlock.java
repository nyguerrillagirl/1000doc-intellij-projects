package com.brainycode.abstractdocument;

import java.util.Map;

public class TranscriptBlock extends AbstractDocument implements
        HasText, HasLanguage {

    public TranscriptBlock(Map<String, Object> props) {
        super(props);
    }
}

