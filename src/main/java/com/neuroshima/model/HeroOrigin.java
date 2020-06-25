package com.neuroshima.model;

import com.neuroshima.origins.Origin;

public class HeroOrigin
{
    public Origin origin;
    public String quality;
    public boolean qualityGivenUp;

    public HeroOrigin(Origin origin, String quality, boolean qualityGivenUp)
    {
        this.origin = origin;
        this.quality = quality;
        this.qualityGivenUp = qualityGivenUp;
    }
}
