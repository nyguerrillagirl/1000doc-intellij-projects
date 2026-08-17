package com.brainycode.abstractdocument;

import java.util.Map;

public class Article extends AbstractDocument implements
        HasAuthor, HasCreatedDate, HasTags {

    public Article(Map<String, Object> props) {
        super(props);
    }
}
