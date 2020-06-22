package com.neuroshima.jobs;

import java.util.ArrayList;

public class Spec extends Job
{
    public Spec()
    {
        this.name = "Spec";
        ArrayList<String> features = new ArrayList<>();
        features.add("Education");
        features.add("Focus");
        this.features = features;
    }
}
