package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class Mississippi extends Origin
{
    public Mississippi()
    {
        this.name = "Mississippi";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Something stinks here");
        qualities.add("Let's go, he's drowned for sure");
        qualities.add("Acid in veins, chlorine in lungs");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 0, 1, 0);
    }
}
