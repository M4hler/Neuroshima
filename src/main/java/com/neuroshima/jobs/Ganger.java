package com.neuroshima.jobs;

import java.util.ArrayList;

public class Ganger extends Job
{
    public Ganger()
    {
        this.name = "Ganger";
        ArrayList<String> features = new ArrayList<>();
        features.add("One of them");
        features.add("Brave or stupid?");
        this.features = features;
    }
}
