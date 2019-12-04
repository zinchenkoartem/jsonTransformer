package com.pipeline.json.transformer.processor.impl;

import com.pipeline.json.transformer.processor.Processor;
import java.util.Map;

public class RemoveFieldProcessor implements Processor {

    private final static String FIELD_NAME = "fieldName";
    private Map<String, String> configuration;

    @Override
    public void initialize(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        if (configuration.get(FIELD_NAME) != null) {
            jsonDocument.remove(configuration.get(FIELD_NAME));
        }
    }
}
