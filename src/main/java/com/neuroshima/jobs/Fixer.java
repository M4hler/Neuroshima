package com.neuroshima.jobs;

import java.util.ArrayList;

public class Fixer extends Job
{
    public Fixer()
    {
        this.name = "Fixer";
        ArrayList<String> features = new ArrayList<>();
        features.add("Matches and safety pin");
        features.add("Troublesome excess");
        this.features = features;
    }
}
