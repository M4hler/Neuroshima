package com.neuroshima.jobs;

import java.util.ArrayList;

public class ClanWarrior extends Job
{
    public ClanWarrior()
    {
        this.name = "Clan warrior";
        ArrayList<String> features = new ArrayList<>();
        features.add("Us and them");
        features.add("This is my house");
        this.features = features;
    }
}
