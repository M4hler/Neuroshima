package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class Miami extends Origin
{
    public Miami()
    {
        this.name = "Miami";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Alligator man");
        qualities.add("I was already ill");
        qualities.add("Walkabout");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 0, 1, 0);
    }
}
