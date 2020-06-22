package com.neuroshima.jobs;

import java.util.ArrayList;

public class BeastsTrainer extends Job
{
    public BeastsTrainer()
    {
        this.name = "Beast trainer";
        ArrayList<String> features = new ArrayList<>();
        features.add("Beast");
        features.add("Lupine fang");
        this.features = features;
    }
}
