package com.neuroshima.model;

import com.neuroshima.jobs.Job;

public class HeroJob
{
    public Job job;
    public String feature;

    public HeroJob(Job job, String feature)
    {
        this.job = job;
        this.feature = feature;
    }
}
