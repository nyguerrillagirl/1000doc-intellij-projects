package com.brainycode.demo;

import java.util.Map;

public class VideoContent extends Document implements
    HasAuthor, HasCreatedDate, HasTags, HasDuration, HasResolution {

    public VideoContent(Map<String, Object> props) {
        super(props);
    }
}
