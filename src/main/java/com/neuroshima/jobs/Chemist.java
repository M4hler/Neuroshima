package com.neuroshima.jobs;

import java.util.ArrayList;

public class Chemist extends Job
{
    public Chemist()
    {
        this.name = "Chemist";
        ArrayList<String> features = new ArrayList<>();
        features.add("It tastes like arsenic");
        features.add("Pharmacist");
        this.features = features;
    }
}
