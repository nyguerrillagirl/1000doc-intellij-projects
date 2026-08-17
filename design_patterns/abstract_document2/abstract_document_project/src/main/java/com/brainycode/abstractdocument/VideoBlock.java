package com.brainycode.abstractdocument;

import java.util.Map;

public class VideoBlock extends AbstractDocument implements
        HasDuration, HasResolution {

    public VideoBlock(Map<String, Object> props) {
        super(props);
    }
}

