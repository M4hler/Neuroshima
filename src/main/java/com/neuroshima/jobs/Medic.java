package com.neuroshima.jobs;

import java.util.ArrayList;

public class Medic extends Job
{
    public Medic()
    {
        this.name = "Medic";
        ArrayList<String> features = new ArrayList<>();
        features.add("Reputation");
        features.add("Field medic");
        this.features = features;
    }
}
