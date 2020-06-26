package com.neuroshima.model;

import com.neuroshima.jobs.Job;
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
        return heroOrigin != null
                && heroOrigin.origin != null
                && (heroOrigin.qualityGivenUp || heroOrigin.quality != null);
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

    public void manageHeroJob(Job job)
    {
        if(heroJob == null)
        {
            heroJob = new HeroJob(job, null, false);
        }
        else if(heroJob.featureGivenUp)
        {
            if(job.features.contains(heroJob.feature))
            {
                heroJob = new HeroJob(job, heroJob.feature, false);
            }
            else
            {
                heroJob = new HeroJob(job, null, false);
            }
            gambles -= 50;
        }
        else
        {
            if(job.features.contains(heroJob.feature))
            {
                heroJob = new HeroJob(job, heroJob.feature, false);
            }
            else
            {
                heroJob = new HeroJob(job, null, false);
            }
        }
    }

    public void manageHeroJob(Job job, String feature)
    {
        if(heroJob.featureGivenUp)
        {
            gambles -= 50;
        }

        heroJob = new HeroJob(job, feature, false);
    }

    public void giveUpFeature()
    {
        if(heroJob == null)
        {
            heroJob = new HeroJob(null, null, true);
            gambles += 50;
        }
        else if(!heroJob.featureGivenUp)
        {
            heroJob = new HeroJob(heroJob.job, null, true);
            gambles += 50;
        }
    }
}
