package com.neuroshima.jobs;

import java.util.ArrayList;

public class Courier extends Job
{
    public Courier()
    {
        this.name = "Courier";
        ArrayList<String> features = new ArrayList<>();
        features.add("Connections");
        features.add("Hiding place");
        this.features = features;
    }
}
