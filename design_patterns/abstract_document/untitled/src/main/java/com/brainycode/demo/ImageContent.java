package com.brainycode.demo;

import java.util.Map;

public class ImageContent extends Document implements
    HasAuthor, HasCreatedDate, HasTags, HasDimensions, HasImageFormat {

    public ImageContent(Map<String, Object> props) {
        super(props);
    }
}
