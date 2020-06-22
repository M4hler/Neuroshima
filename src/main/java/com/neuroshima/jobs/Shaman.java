package com.neuroshima.jobs;

import java.util.ArrayList;

public class Shaman extends Job
{
    public Shaman()
    {
        this.name = "Shaman";
        ArrayList<String> features = new ArrayList<>();
        features.add("Spirits have spoken");
        features.add("Totem");
        this.features = features;
    }
}
