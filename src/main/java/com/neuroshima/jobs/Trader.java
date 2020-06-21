package com.neuroshima.jobs;

import java.util.ArrayList;

public class Trader extends Job
{
    public Trader()
    {
        this.name = "Trader";
        ArrayList<String> features = new ArrayList<>();
        features.add("Trade route");
        features.add("Fraud");
        this.features = features;
    }
}
