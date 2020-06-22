package com.neuroshima.jobs;

import java.util.ArrayList;

public class Rat extends Job
{
    public Rat()
    {
        this.name = "Rat";
        ArrayList<String> features = new ArrayList<>();
        features.add("Whatever");
        features.add("Grey man");
        this.features = features;
    }
}
