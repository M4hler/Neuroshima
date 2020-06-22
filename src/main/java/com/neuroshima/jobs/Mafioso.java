package com.neuroshima.jobs;

import java.util.ArrayList;

public class Mafioso extends Job
{
    public Mafioso()
    {
        this.name = "Mafioso";
        ArrayList<String> features = new ArrayList<>();
        features.add("Merciless");
        features.add("Class");
        this.features = features;
    }
}
