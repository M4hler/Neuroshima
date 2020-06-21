package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class Vegas extends Origin
{
    public Vegas()
    {
        this.name = "Vegas";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Luck");
        qualities.add("Gambler");
        qualities.add("Telepath");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 1, 0, 0, 0);
    }
}
