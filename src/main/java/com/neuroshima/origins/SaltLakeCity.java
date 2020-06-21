package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class SaltLakeCity extends Origin
{
    public SaltLakeCity()
    {
        this.name = "Salt Lake City";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Fucking preacher");
        qualities.add("I believe");
        qualities.add("Everything was better before the war");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 0, 0, 1);
    }
}
