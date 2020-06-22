package com.neuroshima.jobs;

import java.util.ArrayList;

public class NewEraPreacher extends Job
{
    public NewEraPreacher()
    {
        this.name = "New Era Preacher";
        ArrayList<String> features = new ArrayList<>();
        features.add("Look in my eyes");
        features.add("Amen");
        this.features = features;
    }
}
