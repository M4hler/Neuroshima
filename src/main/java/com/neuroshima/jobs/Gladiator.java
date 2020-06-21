package com.neuroshima.jobs;

import java.util.ArrayList;

public class Gladiator extends Job
{
    public Gladiator()
    {
        this.name = "Gladiator";
        ArrayList<String> features = new ArrayList<>();
        features.add("Unbreakable");
        features.add("Teaspoon");
        this.features = features;
    }
}
