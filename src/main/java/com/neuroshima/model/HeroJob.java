package com.neuroshima.model;

import com.neuroshima.jobs.Job;

public class HeroJob
{
    public Job job;
    public String feature;
    public boolean featureGivenUp;

    public HeroJob(Job job, String feature, boolean featureGivenUp)
    {
        this.job = job;
        this.feature = feature;
        this.featureGivenUp = featureGivenUp;
    }
}
