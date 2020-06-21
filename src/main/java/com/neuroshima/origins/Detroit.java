package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class Detroit extends Origin
{
    public Detroit()
    {
        this.name = "Detroit";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("If it has engine it will start");
        qualities.add("Seventh sweats");
        qualities.add("What a ride!");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 1, 0, 0, 0);
    }
}
