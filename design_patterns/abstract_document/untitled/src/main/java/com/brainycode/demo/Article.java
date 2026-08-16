package com.brainycode.demo;

import java.util.Map;

public class Article extends Document implements
    HasAuthor, HasCreatedDate, HasTags, HasWordCount {

    public Article(Map<String, Object> props) {
        super(props);
    }
}
