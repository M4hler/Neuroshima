package com.neuroshima.jobs;

import java.util.ArrayList;

public class Mercenary extends Job
{
    public Mercenary()
    {
        this.name = "Mercenary";
        ArrayList<String> features = new ArrayList<>();
        features.add("Reputation");
        features.add("Killing machine");
        this.features = features;
    }
}
