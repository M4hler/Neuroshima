package com.neuroshima.origins;

import com.neuroshima.statistics.Statistics;

import java.util.ArrayList;

public abstract class Origin
{
    public String name;
    public Statistics statBonus;
    public ArrayList<String> qualities;

//    public Origin(String name, ArrayList<String> qualities, Statistics statBonus)
//    {
//        this.name = name;
//        this.statBonus = statBonus;
//        this.qualities = qualities;
//    }

    public String getBonusStat()
    {
        if(statBonus.build > 0)
        {
            return "Build";
        }
        else if(statBonus.dexterity > 0)
        {
            return "Dexterity";
        }
        else if(statBonus.character > 0)
        {
            return "Character";
        }
        else if(statBonus.perception > 0)
        {
            return "Perception";
        }
        else if(statBonus.cleverness > 0)
        {
            return "Cleverness";
        }
        else
        {
            return "Any";
        }
    }
}
