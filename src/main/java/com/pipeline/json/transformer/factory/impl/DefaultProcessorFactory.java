package com.pipeline.json.transformer.factory.impl;

import com.pipeline.json.transformer.entity.ProcessorNames;
import com.pipeline.json.transformer.factory.ProcessorFactory;
import com.pipeline.json.transformer.processor.Processor;
import com.pipeline.json.transformer.processor.impl.AddFieldProcessor;
import com.pipeline.json.transformer.processor.impl.CountNumOfFieldsProcessor;
import com.pipeline.json.transformer.processor.impl.RemoveFieldProcessor;

public class DefaultProcessorFactory implements ProcessorFactory {

    private DefaultProcessorFactory(){}

    private static DefaultProcessorFactory instance;

    public static synchronized DefaultProcessorFactory getInstance() {
        if (instance == null) {
            instance = new DefaultProcessorFactory();
        }
        return instance;
    }

    @Override
    public Processor create(String processorName) {

        Processor processor = null;
        switch (ProcessorNames.valueOf(processorName)) {
            case AddField:
                processor = new AddFieldProcessor();
                break;
            case RemoveField:
                processor = new RemoveFieldProcessor();
                break;
            case CountNumOfFields:
                processor = new CountNumOfFieldsProcessor();
                break;
        }
        return processor;
    }

}
