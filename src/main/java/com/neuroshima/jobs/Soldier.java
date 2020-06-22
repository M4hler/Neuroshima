package com.neuroshima.jobs;

import java.util.ArrayList;

public class Soldier extends Job
{
    public Soldier()
    {
        this.name = "Soldier";
        ArrayList<String> features = new ArrayList<>();
        features.add("Training");
        features.add("Routine");
        this.features = features;
    }
}
