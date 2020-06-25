package com.neuroshima.model;

import com.neuroshima.origins.Origin;

public class Hero
{
    public int gambles;
    public String name;
    public String surname;
    public String nickname;
    public HeroJob heroJob;
    public HeroOrigin heroOrigin;

    public Hero()
    {
        gambles = 100;
        name = "";
        surname = "";
        nickname = "";
        heroJob = null;
        heroOrigin = null;
    }

    public boolean heroOriginProperlySetUp()
    {
        if(heroOrigin != null
                && heroOrigin.origin != null
                && (heroOrigin.qualityGivenUp || heroOrigin.quality != null))
        {
                return true;
        }

        return false;
    }

    public void manageHeroOrigin(Origin origin)
    {
        if(heroOrigin == null)
        {
            heroOrigin = new HeroOrigin(origin, null, false);
        }
        else if(heroOrigin.qualityGivenUp)
        {
            if(origin.qualities.contains(heroOrigin.quality))
            {
                heroOrigin = new HeroOrigin(origin, heroOrigin.quality, false);
            }
            else
            {
                heroOrigin = new HeroOrigin(origin, null, false);
            }
            gambles -= 50;
        }
        else
        {
            if(origin.qualities.contains(heroOrigin.quality))
            {
                heroOrigin = new HeroOrigin(origin, heroOrigin.quality, false);
            }
            else
            {
                heroOrigin = new HeroOrigin(origin, null, false);
            }
        }
    }

    public void manageHeroOrigin(Origin origin, String quality)
    {
        if(heroOrigin.qualityGivenUp)
        {
            gambles -= 50;
        }

        heroOrigin = new HeroOrigin(origin, quality, false);
    }

    public void giveUpQuality()
    {
        if(heroOrigin == null)
        {
            heroOrigin = new HeroOrigin(null, null, true);
            gambles += 50;
        }
        else if(!heroOrigin.qualityGivenUp)
        {
            heroOrigin = new HeroOrigin(heroOrigin.origin, null, true);
            gambles += 50;
        }
    }
}
