package com.neuroshima.jobs;

import java.util.ArrayList;

public class Killer extends Job
{
    public Killer()
    {
        this.name = "Killer";
        ArrayList<String> features = new ArrayList<>();
        features.add("End of commission");
        features.add("One shot");
        this.features = features;
    }
}
