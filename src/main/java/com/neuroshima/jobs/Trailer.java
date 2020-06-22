package com.neuroshima.jobs;

import java.util.ArrayList;

public class Trailer extends Job
{
    public Trailer()
    {
        this.name = "Trailer";
        ArrayList<String> features = new ArrayList<>();
        features.add("Sensitive senses");
        features.add("Creature recognition");
        this.features = features;
    }
}
