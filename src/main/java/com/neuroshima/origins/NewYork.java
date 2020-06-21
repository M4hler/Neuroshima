package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class NewYork extends Origin
{
    public NewYork()
    {
        this.name = "New York";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Virtues of classic education");
        qualities.add("Vision");
        qualities.add("Time of patriots");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 1, 0, 0);
    }
}
