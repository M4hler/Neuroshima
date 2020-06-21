package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class Texas extends Origin
{
    public Texas()
    {
        this.name = "Texas";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Man called a horse");
        qualities.add("Doctor Quinn");
        qualities.add("Healthy neighbourhood");
        this.qualities = qualities;
        this.statBonus = new Statistics(1, 0, 0, 0, 0);
    }
}
