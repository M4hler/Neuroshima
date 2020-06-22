package com.neuroshima.jobs;

import java.util.ArrayList;

public class MachineKiller extends Job
{
    public MachineKiller()
    {
        this.name = "Machine killer";
        ArrayList<String> features = new ArrayList<>();
        features.add("Weak point");
        features.add("Empiric");
        this.features = features;
    }
}
