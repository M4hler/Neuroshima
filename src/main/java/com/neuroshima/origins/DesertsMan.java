package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class DesertsMan extends Origin
{
    public DesertsMan()
    {
        this.name = "Desert's man";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Companion");
        qualities.add("I'm the ghost of the desert");
        qualities.add("I rely only on myself");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 0, 1, 0);
    }
}
