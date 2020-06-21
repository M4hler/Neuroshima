package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public class AManFromNotYourBusiness extends Origin
{
    public AManFromNotYourBusiness()
    {
        this.name = "A man from... not your fucking business";
        ArrayList<String> qualities = new ArrayList<>();
        qualities.add("Versatility");
        qualities.add("Versatility squared");
        this.qualities = qualities;
        this.statBonus = new Statistics(0, 0, 0, 0, 0);
    }
}
