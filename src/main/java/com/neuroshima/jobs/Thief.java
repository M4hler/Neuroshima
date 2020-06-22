package com.neuroshima.jobs;

import java.util.ArrayList;

public class Thief extends Job
{
    public Thief()
    {
        this.name = "Thief";
        ArrayList<String> features = new ArrayList<>();
        features.add("Electronic");
        features.add("Cat");
        this.features = features;
    }
}
