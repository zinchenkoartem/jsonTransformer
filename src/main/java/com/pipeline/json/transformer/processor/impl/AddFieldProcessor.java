package com.pipeline.json.transformer.processor.impl;

import com.pipeline.json.transformer.processor.Processor;
import java.util.HashMap;
import java.util.Map;

public class AddFieldProcessor implements Processor {

    private final static String FIELD_NAME = "fieldName";
    private final static String FIELD_VALUE = "fieldValue";
    private Map<String, String> configuration = new HashMap<>();

    @Override
    public void initialize(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        if (configuration.get(FIELD_NAME) != null) {
            jsonDocument.put(configuration.get(FIELD_NAME), configuration.get(FIELD_VALUE));
        }
    }
}
