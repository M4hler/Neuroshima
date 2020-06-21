package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class SouthHegemony extends Origin
{
    public SouthHegemony()
    {
        this.name = "South Hegemony";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Born killer");
        qualities.add("You know, I've eaten my own dog");
        qualities.add("Fierce motherfucker");
        this.qualities = qualities;
        this.statBonus = new Statistics(1, 0, 0, 0, 0);
    }
}
