package com.pipeline.json.transformer.factory;

import com.pipeline.json.transformer.processor.Processor;

public interface ProcessorFactory {

    Processor create(String processorName);

}
