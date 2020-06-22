package com.neuroshima.jobs;

import java.util.ArrayList;

public class Judge extends Job
{
    public Judge()
    {
        this.name = "Judge";
        ArrayList<String> features = new ArrayList<>();
        features.add("Uniform and badge");
        features.add("One of us");
        this.features = features;
    }
}
