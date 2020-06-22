package com.neuroshima.jobs;

import java.util.ArrayList;

public class Cowboy extends Job
{
    public Cowboy()
    {
        this.name = "Cowboy";
        ArrayList<String> features = new ArrayList<>();
        features.add("Gunman");
        features.add("Last bullet");
        this.features = features;
    }
}
