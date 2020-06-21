package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class Post extends Origin
{
    public Post()
    {
        this.name = "Post";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("It worked on the simulator...");
        qualities.add("Hi-Tech");
        qualities.add("Moloch? I heard something about it");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 0, 0, 1);
    }
}
