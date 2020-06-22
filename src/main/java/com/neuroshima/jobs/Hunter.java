package com.neuroshima.jobs;

import java.util.ArrayList;

public class Hunter extends Job
{
    public Hunter()
    {
        this.name = "Hunter";
        ArrayList<String> features = new ArrayList<>();
        features.add("Photographic memory");
        features.add("Adamant");
        this.features = features;
    }
}
