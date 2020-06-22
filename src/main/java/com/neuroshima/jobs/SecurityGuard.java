package com.neuroshima.jobs;

import java.util.ArrayList;

public class SecurityGuard extends Job
{
    public SecurityGuard()
    {
        this.name = "Security Guard";
        ArrayList<String> features = new ArrayList<>();
        features.add("Mute");
        features.add("Before him");
        this.features = features;
    }
}
