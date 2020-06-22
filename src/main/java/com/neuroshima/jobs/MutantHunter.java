package com.neuroshima.jobs;

import java.util.ArrayList;

public class MutantHunter extends Job
{
    public MutantHunter()
    {
        this.name = "Mutant hunter";
        ArrayList<String> features = new ArrayList<>();
        features.add("No secrets");
        features.add("Mutant for breakfast");
        this.features = features;
    }
}
