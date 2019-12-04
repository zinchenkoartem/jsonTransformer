package com.pipeline.json.transformer.executor;

import com.pipeline.json.transformer.entity.PipelineDescriptor;
import com.pipeline.json.transformer.factory.ProcessorFactory;
import com.pipeline.json.transformer.factory.impl.DefaultProcessorFactory;
import com.pipeline.json.transformer.processor.Processor;

import java.util.Map;

public class PipelineExecutor {

    public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument) {

        ProcessorFactory processorFactory = DefaultProcessorFactory.getInstance();

        pipelineDescriptor.getSteps().forEach(e -> {
            Processor processor = processorFactory.create(e.getProcessor());
            processor.initialize(e.getConfiguration());
            processor.process(jsonDocument);
        });
    }
}
