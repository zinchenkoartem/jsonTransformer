package com.pipeline.json.transformer.processor;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pipeline.json.transformer.entity.PipelineDescriptor;
import com.pipeline.json.transformer.executor.PipelineExecutor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.*;

public class PipelineExecutorTest {

    private static Map<String, Object> jsonDocument;
    private static PipelineDescriptor pipelineDescriptor;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void before() throws URISyntaxException, IOException {

        String initialJson = getStringFromResourceFile("initialFile.json");
        String pipelineDescriptorJson = getStringFromResourceFile("pipelineDescriptor.json");

        jsonDocument = mapper.readValue(initialJson, new TypeReference<Map<String, Object>>() {});
        pipelineDescriptor = mapper.readValue(pipelineDescriptorJson, PipelineDescriptor.class);
    }

    @Test
    public void jsonTransformerTest() {
        pipelineDescriptor.getSteps().forEach(System.out::println);
        System.out.println("Before:");
        jsonDocument.forEach((k, v) -> System.out.println(k + " = " + v));
        assertEquals(3, jsonDocument.size());

        System.out.println("------------------");

        new PipelineExecutor().transform(pipelineDescriptor, jsonDocument);

        System.out.println("After:");
        jsonDocument.forEach((k, v) -> System.out.println( k + " = " + v));

        assertEquals(5, jsonDocument.size());
        assertTrue(jsonDocument.containsKey("numOfFields"));
        assertEquals(4, jsonDocument.get("numOfFields"));
        assertTrue(jsonDocument.containsKey("firstName"));
        assertTrue(jsonDocument.containsValue("George"));
    }

    private String getStringFromResourceFile(String filename) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        return new String(Files.readAllBytes(path));
    }
}
