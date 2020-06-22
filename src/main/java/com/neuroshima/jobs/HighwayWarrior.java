package com.neuroshima.jobs;

import java.util.ArrayList;

public class HighwayWarrior extends Job
{
    public HighwayWarrior()
    {
        this.name = "Highway warrior";
        ArrayList<String> features = new ArrayList<>();
        features.add("Door to door");
        features.add("Car cover");
        this.features = features;
    }
}
