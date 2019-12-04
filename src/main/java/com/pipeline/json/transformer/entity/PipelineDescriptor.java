package com.pipeline.json.transformer.entity;

import java.util.List;

public class PipelineDescriptor {

    private List<Step> steps;

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
