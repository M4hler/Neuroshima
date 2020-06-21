package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class AppalachsFederation extends Origin
{
    public AppalachsFederation()
    {
        this.name = "Appalach's Federation";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Nobly born");
        qualities.add("Duellist");
        qualities.add("Beautiful gun");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 1, 0 ,0);
    }
}
